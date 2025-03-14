package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.maintenance.TDB_Maintenance;
import com.kmmaltairlines.mail.EmailRequest;
import com.kmmaltairlines.mail.MailService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IterateOverDoneFileEntries {
	@Autowired
	private OneIteration oneIteration;
	@Autowired
	private PreprocessTdbBatchSubflow tdbBatch;
	@Autowired
	private MailService mailService;
	@Autowired
	private EmailRequest emailRequest;
	@Autowired
	private XmlGenerator xmlGenerator;
	
	ArrayList<TDB_Maintenance> report  = new ArrayList<>();
	int numSuccessfullyProcessedDatFiles,numUnsuccessfullyProcessedDatFiles=0;
	// Logger for logging events and errors
	private static final Logger logger = LogManager.getLogger(IterateOverDoneFileEntries.class);

	// Method to iterate over the entries in the .done file and process them
	public void iterateOverDoneFile(HashMap<String, String> doneFileEntryList, ArrayList<DoneFileEntry> dotFiles,
			String encFileName, Connection connection) throws IOException, SQLException {
		Map<String, Object> variables = new HashMap<>();
		// Generate a unique run ID for this process
		UUID run_id = UUID.randomUUID();

		// Check if the done file contains "batch" (indicating batch processing is
		// required)
		if (encFileName.contains("batch")) {
			// If batch processing is needed, call the preprocess method to handle batch
			// files
			doneFileEntryList = tdbBatch.process(doneFileEntryList, run_id, dotFiles, encFileName, connection,report);
		} else {
			// If not a batch file, log and skip preprocessing
			logger.info("Skip preprocessing for non BATCH files");
		}

		// Iterate through each entry in the done file entry list and process it
		for (String key : doneFileEntryList.keySet()) {
			// Call the `oneIterationOverDoneFile` method for each file entry to process it
			report = oneIteration.processDoneFiles(key, doneFileEntryList.get(key), run_id, dotFiles,
					encFileName, connection,report);
		}

		// Log after processing all the .dat files
		logger.info("Processed all .dat files.");

		// TODO: Add logic to send an email with the status report (this part is to be
		// implemented)
		// For example, you could call a utility method to generate and send an email
		for(TDB_Maintenance array: report) {
			if(array.getSuccess()==true) {
				numSuccessfullyProcessedDatFiles++;
			}else {
				numUnsuccessfullyProcessedDatFiles++;
			}
		}
		
		String xmlOutput = xmlGenerator.generateXml(report);
		
		variables.put("encFileName", encFileName);
		variables.put("numSuccessfullyProcessedDatFiles", numSuccessfullyProcessedDatFiles);
		variables.put("numUnsuccessfullyProcessedDatFiles", numUnsuccessfullyProcessedDatFiles);
		variables.put("run_id", run_id);
		variables.put("htmlTDBMaintenanceTable", xmlOutput);
		emailRequest.setTemplateMessage("status_report_email_template", variables);
		emailRequest.setSubject("Status Report for " + encFileName + " file");
		mailService.sendEmail(emailRequest);
		logger.info("Successfully built and sent status report.");
	}

}
