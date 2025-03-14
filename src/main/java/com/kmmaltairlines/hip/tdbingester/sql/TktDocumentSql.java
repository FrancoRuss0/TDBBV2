package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kmmaltairlines.hip.tdbingester.filepojos.Res;
import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktDocumentSql")
public class TktDocumentSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktDocumentSql.class);

	/**
	 * Inserts a list of TktCoupon records into the database in bulk.
	 * 
	 * @param tktCoupons - List of TktCoupon objects to be inserted
	 * @param connection - Database connection object
	 * @throws SQLException - If a database error occurs
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {

		ArrayList<TktDocument> tktDocuments = new ArrayList<TktDocument>();
		for (Object flight : flights) {
			tktDocuments.add((TktDocument) flight);
		}

		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktDocument.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		// Add TktCoupon data to the batch for bulk insertion
		for (TktDocument document : tktDocuments) {
			stmt.setString(1, document.getID());
			stmt.setString(2, document.getPNRLocatorID());
			stmt.setDate(3, document.getPNRCreateDate());
			stmt.setString(4, document.getPrimaryDocNbr());
			stmt.setDate(5, document.getVCRCreateDate());
			stmt.setTimestamp(6, document.getTransactionDateTime());
			stmt.setString(7, document.getAirlineAccountingCode());
			stmt.setString(8, document.getEndDocNbr());
			stmt.setString(9, document.getVendorName());
			stmt.setString(10, document.getPointOfTktIssuance());
			stmt.setString(11, document.getValidatingVendorCode());
			stmt.setString(12, document.getValidatingVendorNbr());
			stmt.setDate(13, document.getPNRPurgeDate());
			stmt.setString(14, document.getCRSPNRLocator());
			stmt.setDate(15, document.getDocIssueDate());
			stmt.setString(16, document.getCustomerFullName());
			stmt.setString(17, document.getAgentCountryCode());
			stmt.setString(18, document.getIntlDocSaleCode());
			stmt.setString(19, document.getTourCode());
			stmt.setString(20, document.getAgentSine());
			stmt.setString(21, document.getOwningCityCode());
			stmt.setString(22, document.getAAACityCode());
			stmt.setString(23, document.getDocIssueAAAIATANbr());
			stmt.setString(24, document.getHomeCityCode());
			stmt.setString(25, document.getRestrictions());
			stmt.setString(26, document.getCurrConverRate());
			stmt.setShort(27, document.getBankSellRate());
			stmt.setShort(28, document.getBankBuyRate());
			stmt.setShort(29, document.getIntlClearHouseRate());
			stmt.setBigDecimal(30, document.getExchgTktAmt());
			stmt.setString(31, document.getSettlementAuthCode());
			stmt.setString(32, document.getBaseFareCurrCode());
			stmt.setBigDecimal(33, document.getBaseFareAmt());
			stmt.setString(34, document.getTotalFareCurrCode());
			stmt.setBigDecimal(35, document.getTotalDocAmt());
			stmt.setString(36, document.getEquivBaseFareCurrCode());
			stmt.setBigDecimal(37, document.getEquivBaseFareAmt());
			stmt.setString(38, document.getDataInd());
			stmt.setString(39, document.getFareCalc());
			stmt.setByte(40, document.getFareCalcType());
			stmt.setDate(41, document.getOriginalIssueDate());
			stmt.setString(42, document.getOriginalIssueCity());
			stmt.setString(43, document.getOriginalIATANbr());
			stmt.setString(44, document.getOriginalFOP());
			stmt.setString(45, document.getOriginalTktNbr());
			stmt.setString(46, document.getExchgFOP());
			stmt.setString(47, document.getAddlExchgTktData());
			stmt.setString(48, document.getExchgCoupon());
			stmt.setString(49, document.getAutoPriceCode());
			stmt.setString(50, document.getDocTypeCode());
			stmt.setString(51, document.getDocStatusCode());
			stmt.setString(52, document.getPassengerType());
			stmt.setString(53, document.getSourceSystemId());
			stmt.setString(54, document.getOACStationNbr());
			stmt.setString(55, document.getRefundableInd());
			stmt.setString(56, document.getCommissionableInd());
			stmt.setString(57, document.getInterlineInd());
			stmt.setString(58, document.getEMDRFICode());
			stmt.setString(59, document.getEMDType());
			stmt.setString(60, document.getTaxExInd());
			stmt.setString(61, document.getConsumedAtIssueInd());
			stmt.setString(62, document.getElectronicDocumentInd());
			stmt.setString(63, document.getManualDocumentInd());
			stmt.setString(64, document.getVoucherRefundInd());
			stmt.setString(65, document.getRFICode());
			stmt.setString(66, document.getRFITxt());
			stmt.setString(67, document.getPTASvcChargeCurrCode());
			stmt.setBigDecimal(68, document.getPTASvcChargeAmt());
			stmt.setString(69, document.getPTAAddFundsDesc());
			stmt.setString(70, document.getPTAAddFundsCurrCode());
			stmt.setBigDecimal(71, document.getPTAAddFundsAmt());
			stmt.setString(72, document.getExchgChangeFeeCurrCode());
			stmt.setBigDecimal(73, document.getExchgChangeFeeAmt());
			stmt.setString(74, document.getOtherFeeCurrCode());
			stmt.setBigDecimal(75, document.getOtherFeeAmt());
			stmt.setString(76, document.getAddCollectCurrCode());
			stmt.setBigDecimal(77, document.getAddCollectAmt());
			stmt.setString(78, document.getOACDefaultPartitionCode());
			stmt.setString(79, document.getOACCityCode());
			stmt.setString(80, document.getOACAcctCode());
			stmt.setString(81, document.getNonRefFeeCurrCode());
			stmt.setBigDecimal(82, document.getNonRefFeeAmt());
			stmt.setString(83, document.getOBFeeDescText());
			stmt.setString(84, document.getOBFeePricingCode());
			stmt.setString(85, document.getOBFeeWaiverCode());
			stmt.setString(86, document.getOBFeeTotalCurrCode());
			stmt.setBigDecimal(87, document.getOBFeeTotal());
			stmt.setBigDecimal(88, document.getOBFeeTotalUSD());
			stmt.setString(89, document.getPricedPassengerType());
			stmt.setObject(90, utility.nowUtcTimestamp(), Types.TIMESTAMP);
			
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
		ArrayList<TktDocument> tktDocuments = new ArrayList<TktDocument>();
		for (Object flight : flights) {
			tktDocuments.add((TktDocument) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktDocument.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (TktDocument res : tktDocuments) {
			stmt.setString(1, res.getPrimaryDocNbr());
			stmt.setDate(2, res.getVCRCreateDate());
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
	
	public void deleteTemp(Connection connection) throws IOException, SQLException {
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktDocument_Temp.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);
		
		stmt.executeUpdate();
		
		logger.info("Successfully clear TktDocument_Temp");
        stmt.close();
        connection.commit();
	}
}
