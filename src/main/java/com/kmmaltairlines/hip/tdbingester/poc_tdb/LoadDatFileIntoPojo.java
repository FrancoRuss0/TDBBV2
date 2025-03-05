package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSFlight;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;

@Service
public class LoadDatFileIntoPojo {
	@Autowired
    private SqlProperty sqlProperty;
	public LoadDatFileIntoPojo(SqlProperty sqlProperty) {
		this.sqlProperty=sqlProperty;
	}
	private static final Logger logger = LogManager.getLogger(LoadDatFileIntoPojo.class);
	
	public Boolean LoadDatFile(String baseFilename, String doneFileEntryValue,ArrayList<DoneFileEntry> doneFileEntryList) {
		Utility utility = new Utility();
		String filename = baseFilename + ".dwl"; // Sostituisci con la logica di recupero del nome del file
		String directory = "src\\main\\java\\transformations"; // Specifica il percorso relativo o assoluto
		SqlQueries a= new SqlQueries(sqlProperty);
		Path filePath = Paths.get(directory, filename);
		ArrayList<ACSFlight> listTransformationA=new ArrayList<ACSFlight>();
		if (!Files.exists(filePath)) {
			System.err.println("Transformation script does not exist for the file " + filename + ".");
			logger.error("Transformation script does not exist for the file " + filename + ".");
			return false;
		} else {
			System.out.println("Processing .dat file. ");
			logger.info("Processing .dat file. ");
			System.out.println("NOME FILE-> " + baseFilename);
			try {
				TransformationIntoPOJO transformation = new TransformationIntoPOJO();
				ArrayList<Object> listTransformation = transformation.loadDatFileIntoPOJO(doneFileEntryValue, baseFilename);
				if (utility.getRecordsByFilename(baseFilename, doneFileEntryList) == listTransformation.size()) {
					System.out.println("Successfully transformed file into POJOs.");
					logger.info("Successfully transformed file into POJOs.");
					if (listTransformation.size() > 0) {
						
						a.sql(listTransformation,baseFilename);
						
						System.out.println("Successfully persisted all records in the respective table.");
						logger.info("Successfully persisted all records in the respective table.");
					} else {
						System.out.println("No records were present in the TDB file. Skipping.");
						logger.info("No records were present in the TDB file. Skipping.");
					}
					return true;
				} else {
					System.err.println("Number of lines denoted in " + baseFilename
							+ utility.getRecordsByFilename(baseFilename, doneFileEntryList)
							+ " lines does not match number of lines in " + baseFilename + " " + listTransformation.size()
							+ " lines");
					logger.error("Number of lines denoted in " + baseFilename
							+ utility.getRecordsByFilename(baseFilename, doneFileEntryList)
							+ " lines does not match number of lines in " + baseFilename + " " + listTransformation.size()
							+ " lines");
					return false;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
				logger.error(e.getMessage());
				return false;
			}
		}
	}
}
