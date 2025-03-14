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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResDataIndex;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResDataIndexSql")
public class ResDataIndexSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResDataIndexSql.class);

	/**
	 * Inserts ResDataIndex records into the database in bulk.
	 * 
	 * @param resDataIndex - List of ResDataIndex objects to be inserted
	 * @param connessione  - Connection object for the database connection
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResDataIndex> resDataIndex = new ArrayList<ResDataIndex>();
		for (Object flight : flights) {
			resDataIndex.add((ResDataIndex) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResDataIndex.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the ResDataIndex data to the batch for bulk insertion
		for (ResDataIndex dataIndex : resDataIndex) {
			stmt.setString(1, dataIndex.getID());
			stmt.setString(2, dataIndex.getPNRLocatorID());
			stmt.setDate(3, dataIndex.getPNRCreateDate());
			stmt.setTimestamp(4, dataIndex.getFromDateTime());
			stmt.setShort(5, dataIndex.getNameAssociationID());
			stmt.setString(6, dataIndex.getProfileType());
			stmt.setString(7, dataIndex.getProfileValue());
			stmt.setString(8, dataIndex.getSourceSystemId());
			stmt.setDate(9, dataIndex.getRecordUpdateDate());
			stmt.setTime(10, dataIndex.getRecordUpdateTime());
			stmt.setShort(11, dataIndex.getIntraPNRSetNbr());
			stmt.setShort(12, dataIndex.getCDISeqNbr());
			stmt.setString(13, dataIndex.getResActivityCode());
			stmt.setObject(14, utility.nowUtcTimestamp(), Types.TIMESTAMP); 
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
		// Establish database connection
		ArrayList<ResDataIndex> resDataIndex = new ArrayList<ResDataIndex>();
		for (Object flight : flights) {
			resDataIndex.add((ResDataIndex) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResDataIndex.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResDataIndex res : resDataIndex) {
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
