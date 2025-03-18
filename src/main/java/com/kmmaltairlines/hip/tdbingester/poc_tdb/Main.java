package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.google.common.io.CountingInputStream;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.sftp.QuerySingleFileProcessor;
import com.kmmaltairlines.mail.EmailRequest;
import com.kmmaltairlines.mail.MailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication(scanBasePackages = "com") // Marks the class as a Spring Boot application
@EnableScheduling // Enables scheduling of tasks
public class Main {

	private String containerName = "tdbstg"; // The Azure Blob Storage container name
	// Logger for logging application events
	private static final Logger logger = LogManager.getLogger(Main.class);

	// Autowired dependencies (injected services)
	@Autowired
	private Utility utility; // Utility service class for file operations
	@Autowired
	private IterateOverDoneFileEntries iterateOverDoneFileEntries; // Service to iterate over done file entries
	@Autowired
	private Decrypt decrypt; // Service for decrypting files
	@Autowired
	private Unzip unzip; // Service for unzipping files
	@Autowired
	private MailService mailService; // Service for sending emails
	@Autowired
	private EmailRequest emailRequest; // Email request object to set email parameters

	// Configuration values injected from application properties
	@Value("${storage.db.jdbcUrl}")
	private String url; // Database URL
	@Value("${storage.db.user}")
	private String username; // Database username
	@Value("${storage.db.password}")
	private String password; // Database password
	@Value("${pgp.passphrase}")
	private String passphrase; // PGP passphrase for decryption
	@Value("${azure.blob.connString}")
	private String azureConnectionString;
	@Value("${azure.input}")
	private String pathInput;
	@Value("${azure.output}")
	private String pathOutput;

	public static void main(String[] args) throws Exception {
		// Start the Spring Boot application
		SpringApplication.run(Main.class, args);
	}

	// Scheduled task that runs at a fixed interval, based on the configured polling
	// frequency
	@Scheduled(fixedRateString = "${sftp.pollingFrequency}")
	public void scheduledFileProcessing() throws Exception {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, username, password); // Establish a database connection

			// Read blobs from Azure
			List<BlobData> blobs = readToAzure();

			// Check if the list of blobs is empty
			if (blobs.isEmpty()) {
				logger.warn("The list of blobs is empty. There are no files to process.");
				// sendErrorEmail("The list of blobs is empty. There are no files to process.",
				// "", "", "", "No blobs to process.");
				return; // Exit the method if there are no files to process
			}

			char[] passPhraseChars = passphrase.toCharArray();
			HashMap<String, String> filesUnzipped = new HashMap<>();

			try {
				// Iterate through the blobs and process them
				for (BlobData doneBlob : blobs) {
					String doneBlobName = doneBlob.getName();
					String doneBlobContent = doneBlob.getContent();

					// Check if the blob ends with ".done"
					if (doneBlobName.endsWith(".done")) {
						// Split the content of the done file and create corresponding entries
						ArrayList<String> readedFile = new ArrayList<>(Arrays.asList(doneBlobContent.split("\\r?\\n")));
						ArrayList<DoneFileEntry> doneFileEntryList = utility.createDoneFileEntry(readedFile);
						DoneFile doneFile = utility.createDoneFile(doneBlobName, readedFile, doneFileEntryList);
						String encFileName = doneFile.getFileName().substring(0, doneFile.getFileName().length() - 5)
								.concat(".zip.gpg");

						// Look for the encrypted blob with the corresponding name
						for (BlobData encryptedBlob : blobs) {
							if (encryptedBlob.getName().equals(encFileName)) {
								try {
									// Decrypt the file using the passphrase
									byte[] decryptedFile = decrypt.decryptFile(encryptedBlob.getContent().getBytes(),
											passPhraseChars);
									QuerySingleFileProcessor querySingleFileProcessor = new QuerySingleFileProcessor();
									Path tempPath = Files.createTempFile("temp", ".tmp");
									Files.write(tempPath, encryptedBlob.getContent().getBytes());

									// Process the decrypted file and unzip it into memory
									try (InputStream inputStream = Files.newInputStream(tempPath);
											CountingInputStream countingInputStream = (CountingInputStream) querySingleFileProcessor
													.onCall(inputStream)) {
										filesUnzipped = unzip.unzipToMemory(decryptedFile);

										// Compare the file entries and check the file size
										if (utility.compareFileEntries(doneFileEntryList, filesUnzipped, doneFile)) {
											if (countingInputStream.available() != doneFile.getNumberOfBytes()) {
												throw new IOException(
														"File size mismatch between the done file and the decrypted file.");
											} else {
												// Process the file entries and move the blob if successful
												iterateOverDoneFileEntries.iterateOverDoneFile(filesUnzipped,
														doneFileEntryList, encFileName, connection);
												moveBlob(doneBlob.getName());
											}
										}
									} catch (IOException e) {
										if (e.getMessage().equals(
												"File size mismatch between the done file and the decrypted file.")) {
											logger.error("File size mismatch for " + doneBlob.getName() + ": "
													+ e.getMessage());
											sendErrorEmail(e.getMessage(), doneBlob.getName(), encFileName, "",
													Arrays.toString(e.getStackTrace()));
											moveBlob(doneBlob.getName());
										} else {
											logger.error("Error processing file " + doneBlob.getName() + ": "
													+ e.getMessage());
											sendErrorEmail(e.getMessage(), doneBlob.getName(), encFileName, "",
													Arrays.toString(e.getStackTrace()));
											moveBlob(doneBlobName);
										}
										break;
									}
								} catch (Exception e) {
									logger.error("Error processing file " + doneBlob.getName() + ": " + e.getMessage());
									moveBlob(doneBlobName);
									break;
								}
							}
						}
					} else {
						// Move non .done files to the destination folder
						moveBlob(doneBlobName);
					}
				}
			} catch (Exception e) {
				logger.error("Error during scheduled blob processing: " + e.getMessage());
				sendErrorEmail(e.getMessage(), "", "", "", Arrays.toString(e.getStackTrace()));
			} finally {
				if (connection != null) {
					connection.close(); // Close the database connection
				}
			}
		} catch (Exception e) {
			logger.error("Error during database connection: " + e.getMessage());
			sendErrorEmail(e.getMessage(), "", "", "", Arrays.toString(e.getStackTrace())); // Send error email for
																							// database connection
																							// issues
		}
	}

	// Method for sending error emails when issues arise during processing
	private void sendErrorEmail(String errorMessage, String donefileName, String encFileName, String folderPath,
			String e) {
		Map<String, Object> variables = new HashMap<>();
		variables.put("exceptionCause", errorMessage);
		variables.put("donefileName", donefileName);
		variables.put("encFileName", encFileName);

		// Format folder path if necessary
		String formattedFolderPath = "";
		if (folderPath != null && !folderPath.isEmpty()) {
			formattedFolderPath = "Path '" + folderPath + "' doesn't exist";
			variables.put("exceptionStackTrace", formattedFolderPath);
		} else {
			variables.put("exceptionStackTrace", e);
		}

		try {
			emailRequest.setTemplateMessage("exception_email_template", variables); // Set email template
			emailRequest.setSubject("Error in Travel Data Batch Ingester"); // Set email subject
			mailService.sendEmail(emailRequest); // Send email
			logger.info("Error email sent successfully.");
		} catch (Exception emailException) {
			logger.error("Error sending email: " + emailException.getMessage()); // Log email sending failure
		}
	}

	// Method to read blobs from Azure Blob Storage
	protected List<BlobData> readToAzure() {
		// Create a BlobServiceClient to interact with Azure Blob Storage
		BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(azureConnectionString)
				.buildClient();

		// Get the container client for the specified container
		BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

		List<BlobData> results = new ArrayList<>();

		// Iterate through the blobs in the container
		containerClient.listBlobs().forEach(blob -> {
			String blobName = blob.getName();

			// Check if the blob's name starts with the specified pathInput
			if (blobName.startsWith(pathInput) && (blobName.endsWith(".done") || blobName.endsWith(".gpg"))) {
				// Process only ".done" and ".gpg" blobs within the specified input folder
				BlobClient blobClient = containerClient.getBlobClient(blobName);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

				// Download the blob content into the output stream
				blobClient.download(outputStream);

				// Convert the content of the blob into a string
				String content = outputStream.toString();

				// Get the blob name relative to the input path
				int length = blobName.indexOf("/");
				results.add(new BlobData(blobName.substring(length + 1), content)); // Add to results

				try {
					outputStream.close(); // Close the output stream
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		return results; // Return the list of blobs
	}

	// Another version of the readToAzure method (not used in current code)
	protected void readToAzure2() {
		BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(azureConnectionString)
				.buildClient();

		// Create the container client and list blobs
		BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
		containerClient.listBlobs()
				.forEach(blob -> System.out.printf("Name: %s, Directory? %b%n", blob.getName(), blob.isPrefix()));
	}

	// Method to move blobs from one folder to another in Azure Blob Storage
	private void moveBlob(String doneBlobName) {
		BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(azureConnectionString)
				.buildClient();

		// Clients for source and destination containers
		BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

		// Clients for source and destination blobs
		BlobClient sourceBlobClient = containerClient.getBlobClient(pathInput + "/" + doneBlobName);
		BlobClient destinationBlobClient = containerClient.getBlobClient(pathOutput + "/" + doneBlobName);

		try {
			// Copy the blob from source to destination
			destinationBlobClient.beginCopy(sourceBlobClient.getBlobUrl(), null);

			// Wait for a few seconds to ensure the copy operation is complete
			Thread.sleep(5000);

			// Delete the source blob (this replaces the "move" operation)
			sourceBlobClient.delete();

			System.out.println("File successfully moved from the 'files2' folder to the 'fuel' folder.");
		} catch (Exception e) {
			e.printStackTrace(); // Handle any exceptions during the move operation
		}
	}
}
