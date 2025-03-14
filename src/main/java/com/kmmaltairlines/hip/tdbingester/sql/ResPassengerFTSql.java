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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResPassengerFT;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResPassengerFTSql")
public class ResPassengerFTSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResPassengerFTSql.class);

	/**
	 * Inserts ResPassengerFT records into the database in bulk.
	 * 
	 * @param resPassengerFTs - List of ResPassengerFT objects to be inserted
	 * @param connessione     - Connection object for the database connection
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResPassengerFT> resPassengerFTs = new ArrayList<ResPassengerFT>();
		for (Object flight : flights) {
			resPassengerFTs.add((ResPassengerFT) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResPassengerFT.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the ResPassengerFT data to the batch for bulk insertion
		for (ResPassengerFT passengerFT : resPassengerFTs) {
			stmt.setString(1, passengerFT.getID());
			stmt.setString(2, passengerFT.getPNRLocatorID());
			stmt.setDate(3, passengerFT.getPNRCreateDate());
			stmt.setTimestamp(4, passengerFT.getFromDateTime());
			if(passengerFT.getPNRPassengerFTSeqId()==null) {
		    	stmt.setNull(5, Types.NULL);
		    }else{
		    	stmt.setShort(5, passengerFT.getPNRPassengerFTSeqId());
		    }
			if(passengerFT.getPNRPassengerSeqId()==null) {
		    	stmt.setNull(6, Types.NULL);
		    }else{
		    	stmt.setShort(6, passengerFT.getPNRPassengerSeqId());
		    }
			stmt.setString(7, passengerFT.getSourceTypeCode());
			stmt.setString(8, passengerFT.getClassOfService());
			stmt.setString(9, passengerFT.getFrequentTravelerNbr());
			stmt.setString(10, passengerFT.getFTText());
			stmt.setString(11, passengerFT.getFTCurrentStatusCode());
			stmt.setString(12, passengerFT.getFTFlightNumber());
			stmt.setString(13, passengerFT.getReceivingCarrierCode());
			stmt.setString(14, passengerFT.getServiceStartCityCode());
			stmt.setString(15, passengerFT.getServiceEndCityCode());
			stmt.setString(16, passengerFT.getSSRCode());
			stmt.setString(17, passengerFT.getSSRIdTypeCode());
			if(passengerFT.getSSRNbrInParty()==null) {
		    	stmt.setNull(18, Types.NULL);
		    }else{
		    	stmt.setShort(18, passengerFT.getSSRNbrInParty());
		    }
			stmt.setString(19, passengerFT.getVendorCode());
			stmt.setString(20, passengerFT.getHistoryActionCodeId());
			stmt.setDate(21, passengerFT.getRecordUpdateDate());
			stmt.setTime(22, passengerFT.getRecordUpdateTime());
			if(passengerFT.getIntraPNRSetNbr()==null) {
		    	stmt.setNull(23, Types.NULL);
		    }else{
		    	stmt.setShort(23, passengerFT.getIntraPNRSetNbr());
		    }
			stmt.setObject(24, utility.nowUtcTimestamp(), Types.TIMESTAMP); 
			stmt.addBatch(); // Add this record to the batch
		}

		// Execute the batch insert
		int[] results = stmt.executeBatch();

		logger.info("Bulk insert completed successfully. " + results.length + " records inserted.");
		stmt.close();
	}

	@Override
	@Transactional
	public String delete(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<ResPassengerFT> resPassengerFTs = new ArrayList<ResPassengerFT>();
		for (Object flight : flights) {
			resPassengerFTs.add((ResPassengerFT) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResPassengerFT.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResPassengerFT res : resPassengerFTs) {
			stmt.setString(1, res.getPNRLocatorID());
			stmt.setDate(2, res.getPNRCreateDate());
			// Add the statement to the batch
			stmt.addBatch();
		}

		// Execute the batch insert
		int[] results = stmt.executeBatch();
		String back = stmt.executeBatch().toString();
		logger.info("Delete completed successfully. " + results.length + " records deleted.");
		stmt.close();
		return back;
	}
}
