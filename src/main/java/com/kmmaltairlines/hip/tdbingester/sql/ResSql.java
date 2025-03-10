package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.kmmaltairlines.hip.tdbingester.filepojos.Res;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;
public class ResSql {
	/**
	 * Inserts Res records into the database in bulk.
	 * 
	 * @param flights - List of ACSFlight objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException - If an error occurs while reading SQL files
	 */
	@SuppressWarnings("static-access")
	public static void insert(List<Res> reservation,Connection connessione) throws SQLException, IOException {
		Utility a = new Utility();

		// Establish database connection
		Connection conn = connessione;
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = Utility.loadSqlFromFile("src/main/resources/query/InsertACSFlight.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = conn.prepareStatement(sql);

			// Disable auto-commit for batch processing
			conn.setAutoCommit(false);

			// Add the flight data to the batch for bulk insertion
			for (Res res : reservation) {
				 	stmt.setString(1, res.getID());
	                stmt.setString(2, res.getTTYRecordLocator());
	                stmt.setObject(3, res.getOrigPNRCreateDate(), Types.TIMESTAMP);
	                stmt.setObject(4, res.getOrigPNRCreateTime(), Types.TIME);
	                stmt.setString(5, res.getCreateAAACityCode());
	                stmt.setString(6, res.getCreationCountryCode());
	                stmt.setString(7, res.getGrpBookingInd());
	                stmt.setString(8, res.getCorporateInd());
	                stmt.setObject(9, res.getNbrinParty(), Types.INTEGER);
	                stmt.setString(10, res.getTTYAirlineCode());
	                stmt.setString(11, res.getTTYPosInformation());
	                stmt.setObject(12, res.getSeatCount(), Types.INTEGER);
	                stmt.setString(13, res.getSourceSystemId());
	                stmt.setObject(14, res.getPNRCreateTime(), Types.TIME);
	                stmt.setString(15, res.getCreateAgentSine());
	                stmt.setObject(16, res.getNumberOfInfants(), Types.INTEGER);
	                stmt.setString(17, res.getClaimIndicator());
	                stmt.setString(18, res.getCreateIATANr());
	                stmt.setObject(19, res.getPurgeDate(), Types.TIMESTAMP);
	                stmt.setObject(20, res.getMaxIntraPNRSetNbr(), Types.INTEGER);
	                stmt.setString(21, res.getDivideOrigPNRLocatorID());
	                stmt.setString(22, res.getDivideImagePNRInd());
	                stmt.setString(23, res.getCreateAAAOACCityCode());
	                stmt.setString(24, res.getCreateAAAOACAcctCode());
	                stmt.setString(25, res.getOACDefaultPartitionCode());
	                stmt.setString(26, res.getOACCityCode());
	                stmt.setString(27, res.getOACAcctCode());
	                stmt.setString(28, res.getOACStationNbr());
	                stmt.setString(29, res.getCreateHomeCityCode());
	                stmt.setString(30, res.getCodeSharePNRInd());
	                stmt.setString(31, res.getMCPCarrierInd());
	                stmt.setObject(32, Utility.nowUtcTimestamp(), Types.TIMESTAMP);
	                // Add the statement to the batch
	                stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();
			// Commit the transaction
			conn.commit();

			System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
			stmt.close();
	}
}