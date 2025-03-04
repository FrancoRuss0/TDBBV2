package poc_tdb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip {

	// Modifica il metodo per restituire i dati decompressi come un array di byte
	public static HashMap<String, String> unzipToMemory(byte[] decryptedData) throws IOException {
		// Usa un ByteArrayInputStream per leggere i dati decompressi
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decryptedData);
		ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);

		ZipEntry entry;
		// Crea una HashMap per memorizzare i nomi dei file e i relativi contenuti
		HashMap<String, String> filesMap = new HashMap<>();

		while ((entry = zipInputStream.getNextEntry()) != null) {

			// Inizializza un buffer per leggere il contenuto dell'entry
			byte[] buffer = new byte[1024];
			int length;

			// Crea un ByteArrayOutputStream per memorizzare il contenuto del file corrente
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			// Leggi i dati compressi e scrivili nel ByteArrayOutputStream
			while ((length = zipInputStream.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, length);
			}

			// Converte il contenuto decompressato in stringa
			String decompressedString = new String(byteArrayOutputStream.toByteArray(), "UTF-8");

			// Aggiungi il nome del file e il suo contenuto alla mappa
			filesMap.put(entry.getName(), decompressedString);

			// Chiudi l'entry corrente
			zipInputStream.closeEntry();
		}

		// Chiudi lo stream di input ZIP
		zipInputStream.close();

		// Restituisci la mappa contenente i nomi dei file e i rispettivi contenuti
		return filesMap;
	}

}