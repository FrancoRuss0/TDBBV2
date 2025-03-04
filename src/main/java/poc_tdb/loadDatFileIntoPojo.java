package poc_tdb;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;

public class loadDatFileIntoPojo {
	
	private static final Logger logger = LogManager.getLogger(loadDatFileIntoPojo.class);
	
	public static Boolean LoadDatFile(String baseFilename, String doneFileEntryValue,ArrayList<DoneFileEntry> doneFileEntryList) {
		Utility utility = new Utility();
		String filename = baseFilename + ".dwl"; // Sostituisci con la logica di recupero del nome del file
		String directory = "src\\main\\java\\transformations"; // Specifica il percorso relativo o assoluto

		Path filePath = Paths.get(directory, filename);

		if (!Files.exists(filePath)) {
			System.err.println("Transformation script does not exist for the file " + filename + ".");
			logger.error("Transformation script does not exist for the file " + filename + ".");
			return false;
		} else {
			System.out.println("Processing .dat file. ");
			logger.info("Processing .dat file. ");
			System.out.println("NOME FILE-> " + baseFilename);
			try {
				transformationIntoPOJO transformation = new transformationIntoPOJO();
				ArrayList<Object> listTransformation = transformation.LoadDatFileIntoPOJO(doneFileEntryValue, baseFilename);
				if (utility.getRecordsByFilename(baseFilename, doneFileEntryList) == listTransformation.size()) {
					System.out.println("Successfully transformed file into POJOs.");
					logger.info("Successfully transformed file into POJOs.");
					if (listTransformation.size() > 0) {
						// TODO richiamo al flusso persist-#[vars.doneFileEntry.filename]-subflow
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
