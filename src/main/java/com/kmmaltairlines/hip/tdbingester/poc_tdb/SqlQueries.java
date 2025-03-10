package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxBag;
import com.kmmaltairlines.hip.tdbingester.sql.ACSPaxBagSql;


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
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public void sql(List<Object> flights, String baseFilename,Connection conn) throws SQLException, IOException {
		
//		try {
//		// Switch to handle different base filenames and determine the correct insert method
//		switch (baseFilename) {
//		case "ACSPaxBag":
//			// Convert flights to the specific ACSFlight type
//			ArrayList<ACSPaxBag> trasformACSPaxDOCX = new ArrayList<ACSPaxBag>();
//			for (Object flight : flights) {
//				trasformACSPaxDOCX.add((ACSPaxBag) flight);
//			}
//			// Insert ACSFlight records into the database
//			ACSPaxBagSql a= new ACSPaxBagSql();
//			conn.setAutoCommit(false);
//			a.insert(trasformACSPaxDOCX,conn);
//			conn.commit();
//			break;
//
//		default:
//			// Print an error message if no matching filename was found
//			System.err.println("NO MATCH FOUND");
//			break;
//		}
//		
//		conn.close();
//		
//		}catch (SQLException ex){
//			logger.error("Error processing file : " + ex.getMessage());
//			if (conn != null) {
//				conn.rollback(); // Rollback in case of an error
//			}
//		}
//			if (conn != null) {
//				conn.close();
//		}
		
		try {
		    // Trova la classe SQL corrispondente (es: ACSFlight -> ACSFlightSql)
		    String sqlClassName = baseFilename + "Sql";  // Esempio: "ACSFlightSql"
		    Class<?> sqlClass = Class.forName("com.kmmaltairlines.hip.tdbingester.sql." + sqlClassName);
		    System.out.println(sqlClass);
		    
		    // Crea un'istanza della classe SQL (non statica)
		    Object sqlClassInstance = sqlClass.getDeclaredConstructor().newInstance();
		    
		    // Trova il metodo "insert" con i parametri corretti
		    Method insertMethod = sqlClass.getMethod("insert", List.class, Connection.class);
		    
		    // Chiama dinamicamente il metodo di inserimento
		    conn.setAutoCommit(false);
		    insertMethod.invoke(sqlClassInstance, flights, conn); // invoca su un'istanza della classe
		    conn.commit();
		    System.out.println("Inserted " + flights.size() + " records into " + baseFilename);
		} catch (ClassNotFoundException e) {
		    throw new RuntimeException("SQL class not found for: " + baseFilename, e);
		} catch (NoSuchMethodException e) {
		    throw new RuntimeException("Insert method not found for: " + baseFilename, e);
		} catch (Exception e) {
		    throw new RuntimeException("Error executing insert for: " + baseFilename, e);
		} finally {
		    conn.close();  // Assicurati che la connessione venga chiusa
		}
	}
}
