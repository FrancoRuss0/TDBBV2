package poc_tdb;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.airmalta.hip.tdbingester.filepojos.DoneFileEntry;


public class LoadDatFileIntoPojoAndPersistPrivateflow {
	
	public static Boolean LoadDatFileIntoPojoAndPersistPrivateflow(String baseFilename,String doneFileEntryValue,ArrayList<DoneFileEntry> doneFileEntryList) {
		Utility utility = new Utility();
		String filename = baseFilename +".dwl"; // Sostituisci con la logica di recupero del nome del file
		String directory = "src\\main\\java\\transformations"; // Specifica il percorso relativo o assoluto
		
		Path filePath = Paths.get(directory, filename);
		
		if (!Files.exists(filePath)) {
			System.err.println("Transformation script does not exist for the file " + filename + ".");
			return false;
		} else {
			System.out.println("Processing .dat file. ");
			System.out.println("NOME FILE-> "+baseFilename);
	        try {
	        	TransformationLoadDatFileIntoPOJO a = new TransformationLoadDatFileIntoPOJO();
	        	ArrayList<Object>prova= a.LoadDatFileIntoPOJO(doneFileEntryValue,baseFilename);
	            if(utility.getRecordsByFilename(baseFilename, doneFileEntryList) == prova.size()) {
	            	System.out.println("Successfully transformed file into POJOs.");
	            	if(prova.size()>0) {
	            		//TODO richiamo al flusso persist-#[vars.doneFileEntry.filename]-subflow
	            		System.out.println("Successfully persisted all records in the respective table.");
	            	}else {
	            		System.out.println("No records were present in the TDB file. Skipping.");
	            	}
	            	return true;
	            }else {
	            	System.err.println("Number of lines denoted in " + baseFilename + utility.getRecordsByFilename(baseFilename, doneFileEntryList) + " lines does not match number of lines in " + baseFilename + " " + prova.size() + " lines");
	            	return null;
	            }
	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	            return false;
	        }
		}
	}
}
