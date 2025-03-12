package com.kmmaltairlines.hip.tdbingester.sql;

import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;
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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResAddress;

@Component("ResAddressSql")
public class ResAddressSql implements MethodInterface {

	@Autowired
	private Utility utility;
	
	private static final Logger logger = LogManager.getLogger(ResAddressSql.class);

	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<ResAddress> trasformResAddress = new ArrayList<ResAddress>();
		for (Object flight : flights) {
			trasformResAddress.add((ResAddress) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResAddress.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Disable auto-commit for batch processing

		// Add the flight data to the batch for bulk insertion
		for (ResAddress address : trasformResAddress) {
			stmt.setString(1, address.getID());
			stmt.setString(2, address.getAddressLine1());
			stmt.setString(3, address.getAddressLineType_1());
			stmt.setString(4, address.getAddressLine2());
			stmt.setString(5, address.getAddressLineType_2());
			stmt.setString(6, address.getAddressLine3());
			stmt.setString(7, address.getAddressLineType_3());
			stmt.setString(8, address.getAddressLine4());
			stmt.setString(9, address.getAddressLineType_4());
			stmt.setString(10, address.getAddressLine5());
			stmt.setString(11, address.getAddressLineType_5());
			stmt.setString(12, address.getAddressLine6());
			stmt.setString(13, address.getAddressLineType_6());
			stmt.setObject(14, address.getRecordUpdateDate(), Types.DATE);
			stmt.setObject(15, address.getRecordUpdateTime(), Types.TIME);
			stmt.setString(16, address.getHistoryActionCodeId());
			stmt.setInt(17, address.getResAddressSeqID());
			stmt.setShort(18, address.getIntraPNRSetNbr());
			stmt.setObject(19, utility.nowUtcTimestamp(), Types.TIMESTAMP);

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
		ArrayList<ResAddress> trasformResAddress = new ArrayList<ResAddress>();
		for (Object flight : flights) {
			trasformResAddress.add((ResAddress) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResAddress.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResAddress res : trasformResAddress) {
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
