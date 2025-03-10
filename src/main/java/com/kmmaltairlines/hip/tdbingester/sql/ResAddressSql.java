package com.kmmaltairlines.hip.tdbingester.sql;

import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResAddress;

public class ResAddressSql {
	
	@Autowired
	private Utility utility;
		
		public void insert(List<ResAddress> resAddresses,Connection connessione) throws SQLException, IOException {

			// Establish database connection
			Connection conn = connessione;
			PreparedStatement stmt = null;

				// Read the SQL insert query from the file
				String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResAddress.sql");

				// Create a PreparedStatement to execute the SQL query
				stmt = conn.prepareStatement(sql);

				// Disable auto-commit for batch processing

				// Add the flight data to the batch for bulk insertion
				for (ResAddress address : resAddresses) {
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

				System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
		        stmt.close();
		}
		
	}





