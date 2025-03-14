package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.maintenance.TDB_Maintenance;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component
public class TDB_MaintenanceSql {
	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TDB_MaintenanceSql.class);

	public void insert(TDB_Maintenance tdbMaintenance, Connection connection) throws IOException, SQLException {
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTDB_Maintenance.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		stmt.setString(1, tdbMaintenance.getRunId());
		stmt.setString(2, tdbMaintenance.getFileName());
		stmt.setInt(3, tdbMaintenance.getNumRecords());
		stmt.setBoolean(4, tdbMaintenance.getSuccess());
		stmt.setString(5, tdbMaintenance.getEncFileName());
		stmt.setTimestamp(6, tdbMaintenance.getDateStarted());
		stmt.setTimestamp(7, tdbMaintenance.getDateEnded());

		stmt.addBatch(); // Add this record to the batch

		// Execute the batch insert
		int[] results = stmt.executeBatch();

		logger.info("Bulk insert completed successfully. records inserted.");
		stmt.close();

	}
}
