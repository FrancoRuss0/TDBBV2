package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.processing.RecordPrunerUtil;
import com.kmmaltairlines.hip.tdbingester.processing.SabreDuplicateFileRecordPruner;
import com.kmmaltairlines.hip.tdbingester.sql.GetUpdPNR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@Component
public class SqlQueries {
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private Utility utility;
	@Autowired
	private GetUpdPNR getUpdPNR;
	@Autowired
	private RecordPrunerUtil prune;
	
	Map<String, Map<Date, List<Map<String, Object>>>> updatedPNRRecords;
	
	private static final Logger logger = LogManager.getLogger(SqlQueries.class);

	/**
	 * This method processes the flight data based on the provided base filename and
	 * inserts the corresponding records into the database.
	 * 
	 * @param flights      - List of flight objects to be inserted
	 * @param baseFilename - The name of the file that helps determine the data type
	 * @throws Exception 
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public void sql(List<Object> flights, String baseFilename, Connection connection) throws Exception {
		try {
			
			if(baseFilename.contains("Res")) {
				flights=utility.removeDuplicates(flights, baseFilename);
				if(baseFilename.equals("Res")) {
					System.out.println("SOLO RES: "+baseFilename);
					connection.setAutoCommit(false);
					int[] resultUpdPNR= getUpdPNR.insert(flights, connection);
					connection.commit();
					updatedPNRRecords= getUpdPNR.select(connection);
					updatedPNRRecords=utility.groupData(updatedPNRRecords);
				}
				
				flights = utility.filterRecords(flights, updatedPNRRecords);
				
				MethodInterface MethodInterface = (MethodInterface) context.getBean(baseFilename + "Sql");

				// Chiama il metodo insert
				connection.setAutoCommit(false);
				String deleteResult= MethodInterface.delete(flights, connection); 
				connection.commit();
				
				connection.setAutoCommit(false);
				MethodInterface.insert(flights, connection); 
				connection.commit();

			}else {
				MethodInterface MethodInterface = (MethodInterface) context.getBean(baseFilename + "Sql");

				// Chiama il metodo insert
				connection.setAutoCommit(false);
				MethodInterface.insert(flights, connection); // Questo chiama insert() su ACSFlight
				connection.commit();
			}

		} catch (SQLException ex) {
			logger.error("Error processing file : " + ex.getMessage());
			if (connection != null) {
				connection.rollback(); // Rollback in case of an error
			}
		}
	}
}
