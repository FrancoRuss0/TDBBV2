package poc_tdb;

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

public class transformationIntoPOJO {

	public ArrayList<Object> LoadDatFileIntoPOJO(String inputString, String filename)
			throws IOException, ClassNotFoundException {
		// Percorso del file DWL
		String directory = "src\\main\\java\\transformations\\prova.dwl";

		// Leggi lo script DWL dal file
		String dwlScript = new String(Files.readAllBytes(Paths.get(directory)));

		// Crea un motore DataWeave
		DataWeaveScriptingEngine scriptingEngine = new DataWeaveScriptingEngine();

		// Compila lo script DataWeave
		DataWeaveScript compile = scriptingEngine.compile(dwlScript, new String[] { "payload", "filename" });
		// Esegui lo script
		DataWeaveResult result = compile
				.write(new ScriptingBindings().addBinding("payload", inputString, "text/plain", new HashMap<>())
						.addBinding("filename", filename, "text/plain", new HashMap<>()));

		String className = "com.kmmaltairlines.hip.tdbingester.filepojos." + filename;

		// Carica la classe dinamicamente
		Class<?> clazz = Class.forName(className);

		// Ora, supponiamo che il risultato DataWeave sia una lista di oggetti di tipo
		// 'clazz'
		List<Object> list = (List<Object>) result.getContent();

		// Creare un ArrayList del tipo specificato
		ArrayList<Object> typedList = new ArrayList<>();

		// Aggiungi tutti gli oggetti della lista al nuovo ArrayList
		for (Object obj : list) {
			// Esegui il cast del singolo oggetto al tipo specificato
			typedList.add(clazz.cast(obj));
		}

		// Ritorna l'ArrayList con gli oggetti del tipo corretto
		return typedList;
	}

}
