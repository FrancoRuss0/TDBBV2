package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResAirExtraPortionofTravel;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResAirExtraPortionofTravelSql {
	
		
		@Autowired
		Utility utility;
		/**
		 * Inserts ACSFlight records into the database in bulk.
		 * 
		 * @param flights - List of ACSFlight objects to be inserted
		 * @throws SQLException - If an error occurs while executing the SQL query
		 * @throws IOException - If an error occurs while reading SQL files
		 */
		public void insert(List<ResAirExtraPortionofTravel> resAirExtraPortionofTravel,Connection connection) throws SQLException, IOException {

			PreparedStatement stmt = null;

				// Read the SQL insert query from the file
				String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResAirExtraPortionofTravel.sql");

				// Create a PreparedStatement to execute the SQL query
				stmt = connection.prepareStatement(sql);

				// Add the flight data to the batch for bulk insertion
				for (ResAirExtraPortionofTravel airExtraPortion : resAirExtraPortionofTravel) {
					
					 stmt.setString(1, airExtraPortion.getID());
			            stmt.setInt(2, airExtraPortion.getIntraPNRSetNbr());
			            stmt.setTimestamp(3, airExtraPortion.getTransmissionDateTime());
			            stmt.setInt(4, airExtraPortion.getUniqueComponentID());
			            stmt.setByte(5, airExtraPortion.getAEPortionSeqNbr());
			            stmt.setInt(6, airExtraPortion.getPNRPassengerSeqID());
			            stmt.setString(7, airExtraPortion.getAirlineCode());
			            stmt.setString(8, airExtraPortion.getFlightNbr());
			            stmt.setString(9, airExtraPortion.getClassofService());
			            stmt.setDate(10, airExtraPortion.getServiceStartDate());
			            stmt.setString(11, airExtraPortion.getServiceStartCity());
			            stmt.setString(12, airExtraPortion.getServiceEndCity());
			            stmt.setString(13, airExtraPortion.getEMDNbr());
			            stmt.setShort(14, airExtraPortion.getEmdCouponNbr());
			            stmt.setString(15, airExtraPortion.getETicketNbr());
			            stmt.setShort(16, airExtraPortion.getETicketCpnNbr());
			            stmt.setDate(17, airExtraPortion.getRecordUpdateDate());
			            stmt.setTimestamp(18, airExtraPortion.getRecordUpdateDateTime());
			            stmt.setString(19, airExtraPortion.getMarketingCarrierCode());
			            stmt.setString(20, airExtraPortion.getOpertatingCarrierCode());
			            stmt.setString(21, airExtraPortion.getSourceSystemID());
			            stmt.executeUpdate();
				}

				// Execute the batch insert
				int[] results = stmt.executeBatch();

				System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
		        stmt.close();
		}
	}


