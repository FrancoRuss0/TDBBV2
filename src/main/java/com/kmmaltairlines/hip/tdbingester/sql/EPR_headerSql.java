package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSFlightHistory;
import com.kmmaltairlines.hip.tdbingester.filepojos.EPR_Header;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class EPR_headerSql {
	/**
	 * Inserts ACSFlightHistory records into the database in bulk.
	 * 
	 * @param flights - List of ACSFlightHistory objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException 
	 */
	@SuppressWarnings("static-access")
	public static void insert(List<EPR_Header> flights,Connection connessione) throws SQLException, IOException {

		// Establish database connection
		Connection conn = connessione;
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = Utility.loadSqlFromFile("src/main/resources/query/InsertEpr_header.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = conn.prepareStatement(sql);

			// Disable auto-commit for batch processing
			conn.setAutoCommit(false);

			// Add the flight data to the batch for bulk insertion
			for (EPR_Header EPR_header : flights) {
				stmt.setString(1, EPR_header.getPCC_Cd()); // PCC_Cd
				stmt.setString(2, EPR_header.getUser_Id()); // User_Id
				stmt.setString(3, EPR_header.getAccount_Cd()); // Account_Cd
				stmt.setString(4, EPR_header.getOffice_Cd()); // Office_Cd
				stmt.setString(5, EPR_header.getAgent_Sine()); // Agent_Sine
				stmt.setString(6, EPR_header.getActive_Ind()); // Active_Ind
				stmt.setString(7, EPR_header.getAccess_Method_Txt()); // Access_Method_Txt
				stmt.setString(8, EPR_header.getAgent_Last_Nm()); // Agent_Last_Nm
				stmt.setString(9, EPR_header.getAgent_Initial_Nm()); // Agent_Initial_Nm
				stmt.setString(10, EPR_header.getHome_Office_Cd()); // Home_Office_Cd
				stmt.setString(11, EPR_header.getHome_City_Txt()); // Home_City_Txt
				stmt.setObject(12, EPR_header.getLast_Sign_in_Dt(), Types.TIMESTAMP); // Last_Sign_in_Dt (assuming it's a Date object, convert it to String)
				stmt.setString(13, EPR_header.getPIN_Set_Ind()); // PIN_Set_Ind
				stmt.setString(14, EPR_header.getPassword_Set_Ind()); // Password_Set_Ind
				stmt.setString(15, EPR_header.getPIV_Questions_Ind()); // PIV_Questions_Ind
				stmt.setString(16, EPR_header.getDuty_0_Cd_Ind()); // Duty_0_Cd_Ind
				stmt.setString(17, EPR_header.getDuty_1_Cd_Ind()); // Duty_1_Cd_Ind
				stmt.setString(18, EPR_header.getDuty_2_Cd_Ind()); // Duty_2_Cd_Ind
				stmt.setString(19, EPR_header.getDuty_3_Cd_Ind()); // Duty_3_Cd_Ind
				stmt.setString(20, EPR_header.getDuty_4_Cd_Ind()); // Duty_4_Cd_Ind
				stmt.setString(21, EPR_header.getDuty_5_Cd_Ind()); // Duty_5_Cd_Ind
				stmt.setString(22, EPR_header.getDuty_6_Cd_Ind()); // Duty_6_Cd_Ind
				stmt.setString(23, EPR_header.getDuty_7_Cd_Ind()); // Duty_7_Cd_Ind
				stmt.setString(24, EPR_header.getDuty_8_Cd_Ind()); // Duty_8_Cd_Ind
				stmt.setString(25, EPR_header.getDuty_9_Cd_Ind()); // Duty_9_Cd_Ind
				stmt.setString(26, EPR_header.getDuty_Hash_Cd_Ind()); // Duty_Hash_Cd_Ind
				stmt.setString(27, EPR_header.getDuty_Dash_Cd_Ind()); // Duty_Dash_Cd_Ind
				stmt.setString(28, EPR_header.getDuty_Star_Cd_Ind()); // Duty_Star_Cd_Ind
				stmt.setString(29, EPR_header.getDuty_Slash_Cd_Ind()); // Duty_Slash_Cd_Ind
				stmt.setString(30, EPR_header.getDuty_Mesh_Cd_Ind()); // Duty_Mesh_Cd_Ind
				stmt.setString(31, EPR_header.getDuty_0_Temp_Cd_Ind()); // Duty_0_Temp_Cd_Ind
				stmt.setString(32, EPR_header.getDuty_1_Temp_Cd_Ind()); // Duty_1_Temp_Cd_Ind
				stmt.setString(33, EPR_header.getDuty_2_Temp_Cd_Ind()); // Duty_2_Temp_Cd_Ind
				stmt.setString(34, EPR_header.getDuty_3_Temp_Cd_Ind()); // Duty_3_Temp_Cd_Ind
				stmt.setString(35, EPR_header.getDuty_4_Temp_Cd_Ind()); // Duty_4_Temp_Cd_Ind
				stmt.setString(36, EPR_header.getDuty_5_Temp_Cd_Ind()); // Duty_5_Temp_Cd_Ind
				stmt.setString(37, EPR_header.getDuty_6_Temp_Cd_Ind()); // Duty_6_Temp_Cd_Ind
				stmt.setString(38, EPR_header.getDuty_7_Temp_Cd_Ind()); // Duty_7_Temp_Cd_Ind
				stmt.setString(39, EPR_header.getDuty_8_Temp_Cd_Ind()); // Duty_8_Temp_Cd_Ind
				stmt.setString(40, EPR_header.getDuty_9_Temp_Cd_Ind()); // Duty_9_Temp_Cd_Ind
				stmt.setString(41, EPR_header.getDuty_Hash_Temp_Cd_Ind()); // Duty_Hash_Temp_Cd_Ind
				stmt.setString(42, EPR_header.getDuty_Dash_Temp_Cd_Ind()); // Duty_Dash_Temp_Cd_Ind
				stmt.setString(43, EPR_header.getDuty_Star_Temp_Cd_Ind()); // Duty_Star_Temp_Cd_Ind
				stmt.setString(44, EPR_header.getDuty_Slash_Temp_Cd_Ind()); // Duty_Slash_Temp_Cd_Ind
				stmt.setString(45, EPR_header.getDuty_Mesh_Temp_Cd_Ind()); // Duty_Mesh_Temp_Cd_Ind
				stmt.setInt(46, EPR_header.getSCR_Group()); // SCR_Group (assuming it's an Integer, convert to String)
				stmt.setString(47, EPR_header.getRecordStatus()); // RecordStatus
				stmt.setString(48, EPR_header.getKeyword_Changed()); // Keyword_Changed
				stmt.setObject(49, EPR_header.getEffectiveDate(), Types.TIMESTAMP); // EffectiveDate (assuming it's a Date object, convert it to String)
				stmt.setString(50, EPR_header.getMCP_Partition_Code()); // MCP_Partition_Code
				stmt.setString(51, EPR_header.getDefault_Ticketing_Carrier()); // Default_Ticketing_Carrier
				stmt.setString(52, EPR_header.getStation_Code()); // Station_Code
				
				stmt.setString(53, EPR_header.getPCC_Cd()); // PCC_Cd
				stmt.setString(54, EPR_header.getUser_Id()); // User_Id
				stmt.setString(55, EPR_header.getAccount_Cd()); // Account_Cd
				stmt.setString(56, EPR_header.getOffice_Cd()); // Office_Cd
				stmt.setString(57, EPR_header.getAgent_Sine()); // Agent_Sine
				stmt.setString(58, EPR_header.getActive_Ind()); // Active_Ind
				stmt.setString(59, EPR_header.getAccess_Method_Txt()); // Access_Method_Txt
				stmt.setString(60, EPR_header.getAgent_Last_Nm()); // Agent_Last_Nm
				stmt.setString(61, EPR_header.getAgent_Initial_Nm()); // Agent_Initial_Nm
				stmt.setString(62, EPR_header.getHome_Office_Cd()); // Home_Office_Cd
				stmt.setString(63, EPR_header.getHome_City_Txt()); // Home_City_Txt
				stmt.setObject(64, EPR_header.getLast_Sign_in_Dt(), Types.TIMESTAMP); // Last_Sign_in_Dt (assuming it's a Date object, convert it to String)
				stmt.setString(65, EPR_header.getPIN_Set_Ind()); // PIN_Set_Ind
				stmt.setString(66, EPR_header.getPassword_Set_Ind()); // Password_Set_Ind
				stmt.setString(67, EPR_header.getPIV_Questions_Ind()); // PIV_Questions_Ind
				stmt.setString(68, EPR_header.getDuty_0_Cd_Ind()); // Duty_0_Cd_Ind
				stmt.setString(69, EPR_header.getDuty_1_Cd_Ind()); // Duty_1_Cd_Ind
				stmt.setString(70, EPR_header.getDuty_2_Cd_Ind()); // Duty_2_Cd_Ind
				stmt.setString(71, EPR_header.getDuty_3_Cd_Ind()); // Duty_3_Cd_Ind
				stmt.setString(72, EPR_header.getDuty_4_Cd_Ind()); // Duty_4_Cd_Ind
				stmt.setString(73, EPR_header.getDuty_5_Cd_Ind()); // Duty_5_Cd_Ind
				stmt.setString(74, EPR_header.getDuty_6_Cd_Ind()); // Duty_6_Cd_Ind
				stmt.setString(75, EPR_header.getDuty_7_Cd_Ind()); // Duty_7_Cd_Ind
				stmt.setString(76, EPR_header.getDuty_8_Cd_Ind()); // Duty_8_Cd_Ind
				stmt.setString(77, EPR_header.getDuty_9_Cd_Ind()); // Duty_9_Cd_Ind
				stmt.setString(78, EPR_header.getDuty_Hash_Cd_Ind()); // Duty_Hash_Cd_Ind
				stmt.setString(79, EPR_header.getDuty_Dash_Cd_Ind()); // Duty_Dash_Cd_Ind
				stmt.setString(80, EPR_header.getDuty_Star_Cd_Ind()); // Duty_Star_Cd_Ind
				stmt.setString(81, EPR_header.getDuty_Slash_Cd_Ind()); // Duty_Slash_Cd_Ind
				stmt.setString(82, EPR_header.getDuty_Mesh_Cd_Ind()); // Duty_Mesh_Cd_Ind
				stmt.setString(83, EPR_header.getDuty_0_Temp_Cd_Ind()); // Duty_0_Temp_Cd_Ind
				stmt.setString(84, EPR_header.getDuty_1_Temp_Cd_Ind()); // Duty_1_Temp_Cd_Ind
				stmt.setString(85, EPR_header.getDuty_2_Temp_Cd_Ind()); // Duty_2_Temp_Cd_Ind
				stmt.setString(86, EPR_header.getDuty_3_Temp_Cd_Ind()); // Duty_3_Temp_Cd_Ind
				stmt.setString(87, EPR_header.getDuty_4_Temp_Cd_Ind()); // Duty_4_Temp_Cd_Ind
				stmt.setString(88, EPR_header.getDuty_5_Temp_Cd_Ind()); // Duty_5_Temp_Cd_Ind
				stmt.setString(89, EPR_header.getDuty_6_Temp_Cd_Ind()); // Duty_6_Temp_Cd_Ind
				stmt.setString(90, EPR_header.getDuty_7_Temp_Cd_Ind()); // Duty_7_Temp_Cd_Ind
				stmt.setString(91, EPR_header.getDuty_8_Temp_Cd_Ind()); // Duty_8_Temp_Cd_Ind
				stmt.setString(92, EPR_header.getDuty_9_Temp_Cd_Ind()); // Duty_9_Temp_Cd_Ind
				stmt.setString(93, EPR_header.getDuty_Hash_Temp_Cd_Ind()); // Duty_Hash_Temp_Cd_Ind
				stmt.setString(94, EPR_header.getDuty_Dash_Temp_Cd_Ind()); // Duty_Dash_Temp_Cd_Ind
				stmt.setString(95, EPR_header.getDuty_Star_Temp_Cd_Ind()); // Duty_Star_Temp_Cd_Ind
				stmt.setString(96, EPR_header.getDuty_Slash_Temp_Cd_Ind()); // Duty_Slash_Temp_Cd_Ind
				stmt.setString(97, EPR_header.getDuty_Mesh_Temp_Cd_Ind()); // Duty_Mesh_Temp_Cd_Ind
				stmt.setInt(98, EPR_header.getSCR_Group()); // SCR_Group (assuming it's an Integer, convert to String)
				stmt.setString(99, EPR_header.getRecordStatus()); // RecordStatus
				stmt.setString(100, EPR_header.getKeyword_Changed()); // Keyword_Changed
				stmt.setObject(101, EPR_header.getEffectiveDate(), Types.TIMESTAMP); // EffectiveDate (assuming it's a Date object, convert it to String)
				stmt.setString(102, EPR_header.getMCP_Partition_Code()); // MCP_Partition_Code
				stmt.setString(103, EPR_header.getDefault_Ticketing_Carrier()); // Default_Ticketing_Carrier
				stmt.setString(104, EPR_header.getStation_Code()); // Station_Code
				stmt.setObject(105, Utility.nowUtcTimestamp(), Types.TIMESTAMP); // tdb_created_at (it’s not part of `EPR_header`, assumed it's a different variable)
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
