package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSFlight;
import com.kmmaltairlines.hip.tdbingester.filepojos.ACSFlightHistory;

@Service
public class SqlQueries {

	@Autowired
	private SqlProperty sqlProperty;

	public SqlQueries(SqlProperty sqlProperty) {
		this.sqlProperty = sqlProperty;
	}

	public void sql(List<Object> flights, String baseFilename) throws SQLException, IOException {

		switch (baseFilename) {
		case "ACSFlight":
			ArrayList<ACSFlight> trasformACSFlight = new ArrayList<ACSFlight>();
			for (Object flight : flights) {
				trasformACSFlight.add((ACSFlight) flight);
			}
			insertACSFlightRecords(trasformACSFlight);
			break;

		case "ACSFlightHistory":
			ArrayList<ACSFlightHistory> trasformACSFlightHistory = new ArrayList<ACSFlightHistory>();
			for (Object flight : flights) {
				trasformACSFlightHistory.add((ACSFlightHistory) flight);
			}
			insertACSFlightHistoryRecords(trasformACSFlightHistory);
			break;

		default:
			System.err.println("NON HO TROVATO NULLA");
			break;
		}

	}

	public void insertACSFlightRecords(List<ACSFlight> flights) throws SQLException, IOException {
		Utility a = new Utility();
		// Dati di connessione al DB (assicurati di usarne di corretti)

		Connection conn = connessione();
		PreparedStatement stmt = null;

		try {
			// SQL di inserimento
			String sql = loadSqlFromFile("src/main/resources/query/insertACSFlight.sql");

			// Creare un PreparedStatement
			stmt = conn.prepareStatement(sql);

			// Disabilita l'auto commit per batch
			conn.setAutoCommit(false);

			// Aggiungi i dati nel batch
			for (ACSFlight flight : flights) {
				stmt.setString(1, flight.getSourceSystemID());
				stmt.setString(2, flight.getAirlineCode());
				stmt.setString(3, flight.getFltNbr());
				stmt.setObject(4, flight.getServiceStartDate(), Types.TIMESTAMP);
				stmt.setString(5, flight.getAirlineOrigAirport());
				stmt.setString(6, flight.getAirlineDestAirport());
				stmt.setString(7, flight.getSchdAirlineOrigAirport());
				stmt.setString(8, flight.getSchdAirlineDestAirport());
				stmt.setString(9, flight.getAirlineOrigGate());
				stmt.setString(10, flight.getCOGInd());
				stmt.setString(11, flight.getFltOverFlyInd());
				stmt.setString(12, flight.getFltFlagStopInd());
				stmt.setString(13, flight.getFltStubInd());
				stmt.setString(14, flight.getGateReaderLNIATA());
				stmt.setObject(15, flight.getEstServiceEndDate(), Types.TIMESTAMP);
				stmt.setObject(16, flight.getEstServiceEndTime(), Types.TIME);
				stmt.setObject(17, flight.getEstServiceStartDate(), Types.TIMESTAMP);
				stmt.setObject(18, flight.getEstServiceStartTime(), Types.TIME);
				stmt.setObject(19, flight.getSchdServiceStartDate(), Types.TIMESTAMP);
				stmt.setObject(20, flight.getSchdServiceStartTime(), Types.TIME);
				stmt.setObject(21, flight.getSchdServiceEndDate(), Types.TIMESTAMP);
				stmt.setObject(22, flight.getSchdServiceEndTime(), Types.TIME);
				stmt.setObject(23, flight.getFltCloseDate(), Types.TIMESTAMP);
				stmt.setObject(24, flight.getFltCloseTime(), Types.TIME);
				stmt.setObject(25, flight.getPDCDate(), Types.TIMESTAMP);
				stmt.setObject(26, flight.getPDCTime(), Types.TIME);
				stmt.setString(27, flight.getFltLegDelayedInd());
				stmt.setString(28, flight.getFltLegStatus());
				stmt.setString(29, flight.getTailNbr());
				stmt.setObject(30, flight.getMsgCreateDateTime(), Types.TIMESTAMP);
				stmt.setString(31, flight.getEquipmentType());
				stmt.setString(32, flight.getAircraftConfig());
				stmt.setInt(33, flight.getTotalPaxCount());
				stmt.setObject(34, flight.getReservedFutureUse1(), Types.NUMERIC);
				stmt.setObject(35, flight.getReservedFutureUse2(), Types.NUMERIC);
				stmt.setObject(36, flight.getReservedFutureUse3(), Types.NUMERIC);
				stmt.setObject(37, flight.getReservedFutureUse4(), Types.NUMERIC);
				stmt.setObject(38, flight.getReservedFutureUse5(), Types.NUMERIC);
				stmt.setObject(39, flight.getReservedFutureUse6(), Types.NUMERIC);
				stmt.setObject(40, flight.getReservedFutureUse7(), Types.NUMERIC);
				stmt.setObject(41, flight.getReservedFutureUse8(), Types.NUMERIC);
				stmt.setObject(42, flight.getReservedFutureUse9(), Types.NUMERIC);
				stmt.setObject(43, a.nowUtcTimestamp(), Types.TIMESTAMP);
				// Aggiungi alla lista di batch
				stmt.addBatch();
			}

			// Esegui il batch
			int[] results = stmt.executeBatch();
			// Commit la transazione
			conn.commit();

			System.out.println("Bulk insert completato con successo. " + results.length + " record inseriti.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			if (conn != null) {
				conn.rollback(); // In caso di errore, rollback
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void insertACSFlightHistoryRecords(List<ACSFlightHistory> flights) throws SQLException {
	    Utility a = new Utility(); // Presumibilmente una classe che fornisce utility come il timestamp UTC
	    
	    // Connessione al DB
	    Connection conn = connessione();
	    PreparedStatement stmt = null;
	    
	    try {
	        // SQL di inserimento (stessa query dell'XML)
	        String sql = "INSERT INTO ACSFlightHistory ("
	                + "\"SourceSystemID\", "
	                + "\"ACSFltSegDate\", "
	                + "\"AirlineCode\", "
	                + "\"FltNbr\", "
	                + "\"AirlineOrigAirport\", "
	                + "\"AirlineDestAirport\", "
	                + "\"SchdServiceStartTime\", "
	                + "\"AAACityCode\", "
	                + "\"AgentSine\", "
	                + "\"ActionDate\", "
	                + "\"ActionTime\", "
	                + "\"AgntStationLNIATA\", "
	                + "\"ActionItem\", "
	                + "\"AgntDtyCd\", "
	                + "\"AgntHomeStation\", "
	                + "\"MsgCreateDateTime\", "
	                + "\"tdb_created_at\") "
	                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        
	        // Creazione di un PreparedStatement
	        stmt = conn.prepareStatement(sql);
	        
	        // Disabilita l'auto commit per batch
	        conn.setAutoCommit(false);
	        
	        // Aggiungi i dati nel batch
	        for (ACSFlightHistory flightHistory : flights) {
	            stmt.setString(1, flightHistory.getSourceSystemID());
	            stmt.setObject(2, flightHistory.getACSFltSegDate(), Types.TIMESTAMP);  // Assicurati che sia LocalDateTime o Timestamp
	            stmt.setString(3, flightHistory.getAirlineCode());
	            stmt.setString(4, flightHistory.getFltNbr());
	            stmt.setString(5, flightHistory.getAirlineOrigAirport());
	            stmt.setString(6, flightHistory.getAirlineDestAirport());
	            stmt.setObject(7, flightHistory.getSchdServiceStartTime(), Types.TIME); // Assicurati che sia LocalTime o Time
	            stmt.setString(8, flightHistory.getAAACityCode());
	            stmt.setString(9, flightHistory.getAgentSine());
	            stmt.setObject(10, flightHistory.getActionDate(), Types.TIMESTAMP); // Assicurati che sia LocalDateTime o Timestamp
	            stmt.setObject(11, flightHistory.getActionTime(), Types.TIME); // Assicurati che sia LocalTime o Time
	            stmt.setString(12, flightHistory.getAgntStationLNIATA());
	            stmt.setString(13, flightHistory.getActionItem());
	            stmt.setString(14, flightHistory.getAgntDtyCd());
	            stmt.setString(15, flightHistory.getAgntHomeStation());
	            stmt.setObject(16, flightHistory.getMsgCreateDateTime(), Types.TIMESTAMP); // Assicurati che sia LocalDateTime o Timestamp
	            stmt.setObject(17, a.nowUtcTimestamp(), Types.TIMESTAMP);  // Utility per ottenere l'ora UTC
	            
	            // Aggiungi la riga al batch
	            stmt.addBatch();
	        }
	        
	        // Esegui il batch
	        int[] results = stmt.executeBatch();
	        
	        // Commit della transazione
	        conn.commit();
	        
	        System.out.println("Bulk insert completato con successo. " + results.length + " record inseriti.");
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        if (conn != null) {
	            conn.rollback();  // Rollback in caso di errore
	        }
	    } finally {
	        if (stmt != null) {
	            stmt.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    }
	}


	public static String loadSqlFromFile(String filePath) throws IOException {
		// Legge tutto il contenuto del file
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

	public Connection connessione() throws SQLException {
		String url = sqlProperty.getJdbcUrl();
		String username = sqlProperty.getUser();
		String password = sqlProperty.getPassword();

		Connection conn = DriverManager.getConnection(url, username, password);
		;
		return conn;
	}
}
