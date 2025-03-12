package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.springframework.stereotype.Component;

@Component
public class Unzip {

	/**
	 * This method takes a byte array containing encrypted (or compressed) data,
	 * decompresses it, and returns a HashMap with the filenames and their contents.
	 * 
	 * @param decryptedData - The byte array of decrypted (or compressed) data
	 * @return HashMap<String, String> - A map where keys are file names and values are the decompressed file contents as strings
	 * @throws IOException - If there is an error during the decompression process
	 */
	public HashMap<String, String> unzipToMemory(byte[] decryptedData) throws IOException {
		// Create a ByteArrayInputStream to read the decompressed data
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decryptedData);

		// Create a ZipInputStream to read the ZIP file from the ByteArrayInputStream
		ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);

		ZipEntry entry;
		// Create a HashMap to store the file names and their corresponding contents
		HashMap<String, String> filesMap = new HashMap<>();

		// Process each entry in the ZIP file
		while ((entry = zipInputStream.getNextEntry()) != null) {

			// Initialize a buffer to read the entry's content
			byte[] buffer = new byte[1024];
			int length;

			// Create a ByteArrayOutputStream to hold the current entry's content
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			// Read the compressed data and write it to the ByteArrayOutputStream
			while ((length = zipInputStream.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, length);
			}

			// Convert the decompressed content to a string using UTF-8 encoding
			String decompressedString = new String(byteArrayOutputStream.toByteArray(), "UTF-8");

			// Add the filename and its decompressed content to the map
			filesMap.put(entry.getName(), decompressedString);

			// Close the current entry
			zipInputStream.closeEntry();
			byteArrayOutputStream.close();
		}

		// Close the ZIP input stream
		zipInputStream.close();
		byteArrayInputStream.close();

		// Return the map containing file names and their respective decompressed contents
		return filesMap;
	}
}
