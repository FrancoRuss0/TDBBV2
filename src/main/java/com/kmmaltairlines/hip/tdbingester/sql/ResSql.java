package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kmmaltairlines.hip.tdbingester.filepojos.Res;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResSql")
public class ResSql implements MethodInterface{
	
	@Autowired
	Utility utility;
	
	private static final Logger logger = LogManager.getLogger(ResSql.class);
	/**
	 * Inserts Res records into the database in bulk.
	 * 
	 * @param flights - List of ACSFlight objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<Res> trasformRes = new ArrayList<Res>();
		for (Object flight : flights) {
			trasformRes.add((Res) flight);
		}
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertRes.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = connection.prepareStatement(sql);

			// Add the flight data to the batch for bulk insertion
			for (Res res : trasformRes) {
				stmt.setString(1, res.getID());                              
			    stmt.setString(2, res.getPNRLocatorID());                 
			    stmt.setObject(3, res.getPNRCreateDate(), Types.DATE);    
			    stmt.setObject(4, res.getFromDateTime(), Types.TIME);    
			    stmt.setString(5, res.getCreateAAACityCode());                
			    stmt.setString(6, res.getCreationCountryCode());              
			    stmt.setString(7, res.getGrpBookingInd());                    
			    stmt.setString(8, res.getCorporateInd());                     
			    stmt.setObject(9, res.getNbrinParty(), Types.SMALLINT);       
			    stmt.setString(10, res.getTTYAirlineCode());                  
			    stmt.setString(11, res.getTTYRecordLocator());                
			    stmt.setString(12, res.getTTYPosInformation());               
			    stmt.setObject(13, res.getSeatCount(), Types.SMALLINT);       
			    stmt.setString(14, res.getSourceSystemId());                  
			    stmt.setObject(15, res.getPNRCreateTime(), Types.TIME);       
			    stmt.setString(16, res.getCreateAgentSine());                 
			    stmt.setObject(17, res.getNumberOfInfants(), Types.SMALLINT); 
			    stmt.setString(18, res.getClaimIndicator());                  
			    stmt.setString(19, res.getCreateIATANr());                    
			    stmt.setObject(20, res.getPurgeDate(), Types.DATE);           
			    stmt.setObject(21, res.getMaxIntraPNRSetNbr(), Types.SMALLINT); 
			    stmt.setString(22, res.getDivideOrigPNRLocatorID());          
			    stmt.setObject(23, res.getOrigPNRCreateDate(), Types.DATE);   
			    stmt.setObject(24, res.getOrigPNRCreateTime(), Types.TIME);   
			    stmt.setString(25, res.getDivideImagePNRInd());               
			    stmt.setString(26, res.getCreateAAAOACCityCode());            
			    stmt.setString(27, res.getCreateAAAOACAcctCode());            
			    stmt.setString(28, res.getOACDefaultPartitionCode());         
			    stmt.setString(29, res.getOACCityCode());                     
			    stmt.setString(30, res.getOACAcctCode());                     
			    stmt.setString(31, res.getOACStationNbr());                   
			    stmt.setString(32, res.getCreateHomeCityCode());              
			    stmt.setString(33, res.getCodeSharePNRInd());                 
			    stmt.setString(34, res.getMCPCarrierInd());                   
			    stmt.setObject(35, utility.nowUtcTimestamp(), Types.TIMESTAMP); 
	                // Add the statement to the batch
	                stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();

			logger.info("Bulk insert completed successfully. " + results.length + " records inserted.");
	        stmt.close();
	}
	
	@Override
	@Transactional
	public String delete(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<Res> trasformRes = new ArrayList<Res>();
		for (Object flight : flights) {
			trasformRes.add((Res) flight);
		}
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteRes.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = connection.prepareStatement(sql);

			// Add the flight data to the batch for bulk insertion
			for (Res res : trasformRes) {
				 	stmt.setString(1, res.getPNRLocatorID());
				 	stmt.setDate(2, res.getPNRCreateDate());
	                // Add the statement to the batch
	                stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();
			String back=stmt.executeBatch().toString();
			logger.info("Delete completed successfully. " + results.length + " records deleted.");
	        stmt.close();
		return back;
	}
	
	public void deleteTemp(Connection connection) throws IOException, SQLException {
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteRes_Temp.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);
		
		stmt.executeUpdate();
		
		logger.info("Successfully clear Res_Temp");
        stmt.close();
        connection.commit();
	}
}