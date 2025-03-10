package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.PreResSeat;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class PreResSeatSql {
	
	@Autowired
	Utility utility;
	
	public void insert(List<PreResSeat> preResSeats,Connection connessione) throws SQLException, IOException {
		

		// Establish database connection
		Connection conn = connessione;
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertPreResSeat.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = conn.prepareStatement(sql);

			// Add the flight data to the batch for bulk insertion
			for (PreResSeat prs : preResSeats) {
                stmt.setString(1, prs.getID());
                stmt.setShort(2, prs.getPNRPassengerSeqId());
                stmt.setShort(3, prs.getPRSSeqNbr());
                stmt.setString(4, prs.getVendorCode());
                stmt.setString(5, prs.getPRSFlightNumber());
                stmt.setShort(6, prs.getPRSCompartmentNbr() );
                stmt.setShort(7, prs.getPRSRowNbr() );
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

			System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
			stmt.close();
	}
	
}



