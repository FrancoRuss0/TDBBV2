package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSFlight;
import com.kmmaltairlines.hip.tdbingester.filepojos.ACSFlightHistory;
import com.kmmaltairlines.hip.tdbingester.sql.ACSFlightSql;
import com.kmmaltairlines.hip.tdbingester.sql.ACSFlightHistorySql;

@Service
public class SqlQueries {
	
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	/**
	 * This method processes the flight data based on the provided base filename 
	 * and inserts the corresponding records into the database.
	 * 
	 * @param flights - List of flight objects to be inserted
	 * @param baseFilename - The name of the file that helps determine the data type
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException - If an error occurs while reading SQL files
	 */
	public void sql(List<Object> flights, String baseFilename,Connection conn) throws SQLException, IOException {
		
		try {
		// Switch to handle different base filenames and determine the correct insert method
		switch (baseFilename) {
		case "ACSFlight":
			// Convert flights to the specific ACSFlight type
			ArrayList<ACSFlight> trasformACSFlight = new ArrayList<ACSFlight>();
			for (Object flight : flights) {
				trasformACSFlight.add((ACSFlight) flight);
			}
			// Insert ACSFlight records into the database
			ACSFlightSql.insert(trasformACSFlight,conn);
			break;

		case "ACSFlightHistory":
			// Convert flights to the specific ACSFlightHistory type
			ArrayList<ACSFlightHistory> trasformACSFlightHistory = new ArrayList<ACSFlightHistory>();
			for (Object flight : flights) {
				trasformACSFlightHistory.add((ACSFlightHistory) flight);
			}
			// Insert ACSFlightHistory records into the database
			ACSFlightHistorySql.insert(trasformACSFlightHistory,conn);
			break;

		default:
			// Print an error message if no matching filename was found
			System.err.println("NO MATCH FOUND");
			break;
		}
		
		conn.close();
		
		}catch (SQLException ex){
			logger.error("Error processing file : " + ex.getMessage());
			if (conn != null) {
				conn.rollback(); // Rollback in case of an error
			}
		}
			if (conn != null) {
				conn.close();
			}
		}
	}

