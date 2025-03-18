package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.Res;
import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component
public class GetUpdVCR {
	@Autowired
	private Utility utility;

	private static final Logger logger = LogManager.getLogger(GetUpdVCR.class);

	public int[] insert(List<Object> flights, Connection connection)
			throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// Converti il tipo da Object a Res
		ArrayList<TktDocument> trasformTktDocument = new ArrayList<TktDocument>();
		for (Object flight : flights) {
			trasformTktDocument.add((TktDocument) flight);
		}

		PreparedStatement stmt = null;

		// Leggi la query SQL dal file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/TktDocument_Temp.sql");

		// Crea il PreparedStatement per eseguire la query
		stmt = connection.prepareStatement(sql);

		// Aggiungi i dati del volo al batch per l'inserimento in batch
		for (TktDocument flight : trasformTktDocument) {
			stmt.setString(1, flight.getPrimaryDocNbr());
			stmt.setDate(2, flight.getVCRCreateDate());
			stmt.setString(3, flight.getAddlExchgTktData());
			stmt.setTimestamp(4, flight.getTransactionDateTime());
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
		String sql = utility.loadSqlFromFile("src/main/resources/query/select/selectUpadteRecordVCR.sql");

		// Creazione di un oggetto Statement
		stmt = connection.createStatement();

		// Esecuzione della query e ottenimento del risultato
		rs = stmt.executeQuery(sql);

		// Elaborazione del risultato
		while (rs.next()) {
			String primaryDocNbr = rs.getString("PrimaryDocNbr");
			Date vcrCreateDate = rs.getDate("VCRCreateDate");
			String addlExchgTktData = rs.getString("AddlExchgTktData");
			Timestamp fileTransactionDateTime = rs.getTimestamp("FileTransactionDateTime");
			Timestamp dbTransactionDateTime = rs.getTimestamp("DBTransactionDateTime");

			// Verifica che primaryDocNbr non sia null prima di aggiungere
			if (primaryDocNbr != null) {
				// Converti i risultati in una mappa di valori
				Map<String, Object> record = new HashMap<>();
				record.put("PrimaryDocNbr", primaryDocNbr);
				record.put("VCRCreateDate", vcrCreateDate);
				record.put("AddlExchgTktData", addlExchgTktData);
				record.put("FileTransactionDateTime", fileTransactionDateTime);
				record.put("DBTransactionDateTime", dbTransactionDateTime);

				// Ottieni la chiave esterna (PrimaryDocNbr come esempio)
				String key = String.valueOf(primaryDocNbr);

				// Ottieni la chiave interna (VCRCreateDate come esempio)
				Date innerKey = vcrCreateDate;

				if (!recordsToKeep.containsKey(key)) {
					recordsToKeep.put(key, new HashMap<>());

				}

				Map<Date, List<Map<String, Object>>> innerMap = recordsToKeep.get(key);
				if (!innerMap.containsKey(innerKey)) {
					innerMap.put(innerKey, new ArrayList<>());

				}

				innerMap.get(innerKey).add(record);
			}
		}

		return recordsToKeep;
	}

}
