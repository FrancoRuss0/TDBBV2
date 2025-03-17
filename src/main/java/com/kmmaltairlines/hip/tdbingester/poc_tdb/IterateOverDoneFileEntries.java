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

@Component  // Marks this class as a Spring Bean (Component) to be managed by the Spring container
public class IterateOverDoneFileEntries {

    // Autowired dependencies, injected automatically by Spring
    @Autowired
    private OneIteration oneIteration;  // Service to process individual file entries in the .done file
    @Autowired
    private PreprocessTdbBatchSubflow tdbBatch;  // Service to preprocess batch files
    @Autowired
    private MailService mailService;  // Service for sending emails
    @Autowired
    private EmailRequest emailRequest;  // Email request object to set email parameters
    @Autowired
    private XmlGenerator xmlGenerator;  // Service for generating XML reports

    // Variables for tracking the status of processed files
    ArrayList<TDB_Maintenance> report  = new ArrayList<>();
    int numSuccessfullyProcessedDatFiles, numUnsuccessfullyProcessedDatFiles = 0;

    // Logger for logging events and errors
    private static final Logger logger = LogManager.getLogger(IterateOverDoneFileEntries.class);

    // Method to iterate over the entries in the .done file and process them
    public void iterateOverDoneFile(HashMap<String, String> doneFileEntryList, ArrayList<DoneFileEntry> dotFiles,
                                     String encFileName, Connection connection) throws IOException, SQLException {

        // Map to store variables for email template
        Map<String, Object> variables = new HashMap<>();

        // Generate a unique run ID for this process to track the execution
        UUID run_id = UUID.randomUUID();

        // Check if the .done file indicates that batch processing is required
        if (encFileName.contains("batch")) {
            // If it's a batch file, preprocess it before handling individual file entries
            doneFileEntryList = tdbBatch.process(doneFileEntryList, run_id, dotFiles, encFileName, connection, report);
        } else {
            // If it's not a batch file, skip preprocessing
            logger.info("Skip preprocessing for non BATCH files");
        }

        // Iterate through each entry in the done file entry list and process it
        for (String key : doneFileEntryList.keySet()) {
            // Call the method to process each individual .dat file based on the entry
            report = oneIteration.processDoneFiles(key, doneFileEntryList.get(key), run_id, dotFiles, encFileName, connection, report);
        }

        // Log after processing all the .dat files
        logger.info("Processed all .dat files.");

        // Iterate over the report to count successfully and unsuccessfully processed files
        for (TDB_Maintenance array : report) {
            if (array.getSuccess() == true) {
                numSuccessfullyProcessedDatFiles++;
            } else {
                numUnsuccessfullyProcessedDatFiles++;
            }
        }

        // Generate an XML output (a report) based on the processing results
        String xmlOutput = xmlGenerator.generateXml(report);

        // Populate the variables for the email template
        variables.put("encFileName", encFileName);  // Encrypted file name
        variables.put("numSuccessfullyProcessedDatFiles", numSuccessfullyProcessedDatFiles);  // Number of successful file processes
        variables.put("numUnsuccessfullyProcessedDatFiles", numUnsuccessfullyProcessedDatFiles);  // Number of failed file processes
        variables.put("run_id", run_id);  // Unique run ID for tracking
        variables.put("htmlTDBMaintenanceTable", xmlOutput);  // The XML report in HTML format for the email

        // Set the email template and send the email with the status report
        emailRequest.setTemplateMessage("status_report_email_template", variables);
        emailRequest.setSubject("Status Report for " + encFileName + " file");
        mailService.sendEmail(emailRequest);
        
        variables=null;
        xmlOutput=null;
        numSuccessfullyProcessedDatFiles=0;
        numUnsuccessfullyProcessedDatFiles = 0;
        // Log the successful generation and sending of the status report
        logger.info("Successfully built and sent status report.");
        report.clear();
    }

}
