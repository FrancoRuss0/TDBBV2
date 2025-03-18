package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSFlight;
import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxBag;
import com.kmmaltairlines.hip.tdbingester.filepojos.Res;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.OneIteration;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component
public class GetUpdPNR {
	@Autowired
	private Utility utility;

	private static final Logger logger = LogManager.getLogger(GetUpdPNR.class);

	public int[] insert(List<Object> flights, Connection connection)
			throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// Converti il tipo da Object a Res
		ArrayList<Res> trasformACSPaxBag = new ArrayList<Res>();
		for (Object flight : flights) {
			trasformACSPaxBag.add((Res) flight);
		}

		PreparedStatement stmt = null;

		// Leggi la query SQL dal file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/Res_Temp.sql");

		// Crea il PreparedStatement per eseguire la query
		stmt = connection.prepareStatement(sql);

		// Aggiungi i dati del volo al batch per l'inserimento in batch
		for (Res flight : trasformACSPaxBag) {
			stmt.setString(1, flight.getPNRLocatorID());
			stmt.setDate(2, flight.getPNRCreateDate());
			stmt.setTimestamp(3, flight.getFromDateTime());
			// Aggiungi la query al batch
			stmt.addBatch();
		}

		// Esegui il batch e ottieni il risultato come array di interi
		int[] results = stmt.executeBatch();

		// Chiudi il PreparedStatement
		stmt.close();

		// Restituisci la lista di stringhe contenente i risultati
		return results;
	}

	public Map<String, Map<Date, List<Map<String, Object>>>> select(Connection connection)
			throws IOException, SQLException {
		Map<String, Map<Date, List<Map<String, Object>>>> recordsToKeep = new HashMap<>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = utility.loadSqlFromFile("src/main/resources/query/select/selectUpadteRecord.sql");
		// Creazione di un oggetto Statement
		stmt = connection.createStatement();

		// Esecuzione della query e ottenimento del risultato
		rs = stmt.executeQuery(sql);

		// Elaborazione del risultato
		while (rs.next()) {
			String pnrLocatorID = rs.getString("PNRLocatorID");
			Date pnrCreateDate = rs.getDate("PNRCreateDate");
			Timestamp fileFromDateTime = rs.getTimestamp("FileFromDateTime");
			Timestamp dbFromDateTime = rs.getTimestamp("DBFromDateTime");

			// Converti i risultati in una mappa di valori
			Map<String, Object> record = new HashMap<>();
			record.put("PNRLocatorID", pnrLocatorID);
			record.put("PNRCreateDate", pnrCreateDate);
			record.put("FileFromDateTime", fileFromDateTime);
			record.put("DBFromDateTime", dbFromDateTime);

			// Ottieni la chiave esterna (PNRLocatorID come esempio, puoi cambiarlo se
			// necessario)
			String key = String.valueOf(pnrLocatorID);

			// Ottieni la chiave interna (PNRCreateDate come esempio)
			Date innerKey = pnrCreateDate;

			// Crea la mappa interna se non esiste
			if (!recordsToKeep.containsKey(key)) {
				recordsToKeep.put(key, new HashMap<>());
			}

			// Ottieni la lista di record per la data interna
			Map<Date, List<Map<String, Object>>> innerMap = recordsToKeep.get(key);
			if (!innerMap.containsKey(innerKey)) {
				innerMap.put(innerKey, new ArrayList<>());
			}

			// Aggiungi il record alla lista
			innerMap.get(innerKey).add(record);
		}

		return recordsToKeep;
	}
}
