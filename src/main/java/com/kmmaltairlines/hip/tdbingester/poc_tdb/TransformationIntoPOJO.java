package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mule.weave.v2.runtime.DataWeaveResult;
import org.mule.weave.v2.runtime.DataWeaveScript;
import org.mule.weave.v2.runtime.DataWeaveScriptingEngine;
import org.mule.weave.v2.runtime.ScriptingBindings;
import org.springframework.stereotype.Component;

@Component
public class TransformationIntoPOJO {

    /**
     * Loads a .dat file, processes it using a DataWeave script, and converts it into a list of POJO objects.
     * The script is dynamically executed based on the provided input string and filename.
     * 
     * @param inputString - The raw input string representing the content of the .dat file.
     * @param filename - The filename used to determine the target POJO class.
     * @return An ArrayList containing the transformed objects.
     * @throws IOException - If an error occurs while reading the DWL file or performing file operations.
     * @throws ClassNotFoundException - If the dynamically loaded POJO class is not found.
     */
    @SuppressWarnings("unchecked")
	public ArrayList<Object> loadDatFileIntoPOJO(String inputString, String baseFilename)
            throws IOException, ClassNotFoundException {
        // Path to the DWL (DataWeave Language) script file
        String directory = "src\\main\\java\\transformations\\prova.dwl";

        // Read the DWL script from the file into a string
        String dwlScript = new String(Files.readAllBytes(Paths.get(directory)));

        // Create a DataWeave scripting engine
        DataWeaveScriptingEngine scriptingEngine = new DataWeaveScriptingEngine();

        // Compile the DWL script, binding the 'payload' and 'filename' variables to the inputString and filename
        DataWeaveScript compile = scriptingEngine.compile(dwlScript, new String[] { "payload", "filename" });
        
        // Execute the DataWeave script with the provided bindings and capture the result
        DataWeaveResult result = compile
                .write(new ScriptingBindings().addBinding("payload", inputString, "text/plain", new HashMap<>())
                        .addBinding("filename", baseFilename, "text/plain", new HashMap<>()));

        // Dynamically construct the class name based on the filename, assuming it's the name of a POJO class
        String className = "com.kmmaltairlines.hip.tdbingester.filepojos." + baseFilename;

        // Dynamically load the class corresponding to the filename
        Class<?> clazz = Class.forName(className);

        // Assuming the result of the DataWeave script is a list of objects of the dynamically loaded class
        List<Object> list = (List<Object>) result.getContent();

        // Create a typed ArrayList to hold the transformed objects
        ArrayList<Object> typedList = new ArrayList<>();

        // Add each object from the result list to the typed ArrayList
        for (Object obj : list) {
            // Cast each object to the dynamically loaded class type
            typedList.add(clazz.cast(obj));
        }

        // Return the ArrayList containing the objects of the correct type
        return typedList;
    }
}
