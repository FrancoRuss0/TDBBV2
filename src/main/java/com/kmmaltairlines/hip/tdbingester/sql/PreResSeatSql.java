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

import com.kmmaltairlines.hip.tdbingester.filepojos.PreResSeat;
import com.kmmaltairlines.hip.tdbingester.filepojos.Res;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("PreResSeatSql")
public class PreResSeatSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(PreResSeatSql.class);

	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<PreResSeat> trasformPreResSeat = new ArrayList<PreResSeat>();
		for (Object flight : flights) {
			trasformPreResSeat.add((PreResSeat) flight);
		}

		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertPreResSeat.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (PreResSeat prs : trasformPreResSeat) {
			stmt.setString(1, prs.getID());
			stmt.setShort(2, prs.getPNRPassengerSeqId());
			stmt.setShort(3, prs.getPRSSeqNbr());
			stmt.setString(4, prs.getVendorCode());
			stmt.setString(5, prs.getPRSFlightNumber());
			stmt.setShort(6, prs.getPRSCompartmentNbr());
			stmt.setShort(7, prs.getPRSRowNbr());
			stmt.setString(8, prs.getPRSLetter());
			stmt.setString(9, prs.getPRSCurrentStatusCode());
			stmt.setString(10, prs.getSmokingSeatIndicator());
			stmt.setString(11, prs.getNonSmokingSeatIndicator());
			stmt.setString(12, prs.getWindowSeatIndicator());
			stmt.setString(13, prs.getAisleSeatIndicator());
			stmt.setString(14, prs.getLeftSideSeatIndicator());
			stmt.setString(15, prs.getExitSeatIndicator());
			stmt.setString(16, prs.getRightSideSeatIndicator());
			stmt.setString(17, prs.getBulkheadSeatIndicator());
			stmt.setString(18, prs.getUpperCompartmentSeatIndicator());
			stmt.setString(19, prs.getOverWingSeatIndicator());
			stmt.setString(20, prs.getHistoryActionCodeId());
			stmt.setObject(21, prs.getRecordUpdateDate(), Types.DATE);
			stmt.setObject(22, prs.getRecordUpdateTime(), Types.TIME);
			stmt.setShort(23, prs.getIntraPNRSetNbr());
			stmt.setObject(24, utility.nowUtcTimestamp(), Types.TIMESTAMP);
			stmt.addBatch();
		}

		// Execute the batch insert
		int[] results = stmt.executeBatch();

		logger.info("Bulk insert completed successfully. " + results.length + " records inserted.");
		stmt.close();
	}

	@Override
	public String delete(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<PreResSeat> trasformPreResSeat = new ArrayList<PreResSeat>();
		for (Object flight : flights) {
			trasformPreResSeat.add((PreResSeat) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deletePreResSeat.sql.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (PreResSeat res : trasformPreResSeat) {
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
