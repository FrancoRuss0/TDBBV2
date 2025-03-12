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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResAirExtra;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResAirExtraSql")
public class ResAirExtraSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResAirExtraSql.class);

	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResAirExtra> resAirExtra = new ArrayList<ResAirExtra>();
		for (Object flight : flights) {
			resAirExtra.add((ResAirExtra) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResAirExtra.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResAirExtra rae : resAirExtra) {
			stmt.setString(1, rae.getID());
			stmt.setString(2, rae.getRFICode());
			stmt.setString(3, rae.getCommercialName());
			stmt.setString(4, rae.getSSIMCode());
			stmt.setString(5, rae.getSSRCode());
			stmt.setString(6, rae.getBoardPointAirportCode());
			stmt.setString(7, rae.getOffPointAirportCode());
			stmt.setString(8, rae.getOwningCarrierCode());
			stmt.setString(9, rae.getFeeVendorCode());
			stmt.setString(10, rae.getBookingMethodCode());
			stmt.setString(11, rae.getFulfillTypeCode());
			stmt.setShort(12, rae.getEMDTypeCode());
			stmt.setString(13, rae.getRefundReissueCode());
			stmt.setString(14, rae.getFormOfRefundCode());
			stmt.setString(15, rae.getFrequentTravelerTierLevel());
			stmt.setString(16, rae.getBrandedFareId());
			stmt.setString(17, rae.getTourCode());
			stmt.setString(18, rae.getServiceChargeCode());
			stmt.setString(19, rae.getFeeApplicationCode());
			stmt.setDate(20, rae.getFirstTravelDate());
			stmt.setDate(21, rae.getLastTravelDate());
			stmt.setString(22, rae.getHistoryActionCode());
			stmt.setTimestamp(23, rae.getTTYConfirmationDateTime());
			stmt.setTimestamp(24, rae.getPurchaseByDateTime());
			stmt.setString(25, rae.getBookingSourceCode());
			stmt.setString(26, rae.getEMDNbr());
			stmt.setShort(27, rae.getEMDCouponNbr());
			stmt.setString(28, rae.getETicketNbr());
			stmt.setShort(29, rae.getETicketCouponNbr());
			stmt.setString(30, rae.getSSRDirectFulfillCode());
			stmt.setString(31, rae.getNonEMDFormofPayment());
			stmt.setString(32, rae.getFeeWaivedCode());
			stmt.setBigDecimal(33, rae.getAEBasePriceAmount());
			stmt.setString(34, rae.getAEBaseCurrencyCode());
			stmt.setBigDecimal(35, rae.getAEEquivalentPaidAmount());
			stmt.setString(36, rae.getAEEquivalentAmtCurrencyCd());
			stmt.setShort(37, rae.getItemCount());
			stmt.setBigDecimal(38, rae.getAETotalPriceAmount());
			stmt.setString(39, rae.getPassengerTypeCode());
			stmt.setString(40, rae.getTaxIncludedCode());
			stmt.setString(41, rae.getSegmentUseCode());
			stmt.setDate(42, rae.getSegmentBookedDate());
			stmt.setTime(43, rae.getSegmentBookedTime());
			stmt.setString(44, rae.getNonEMDFOPCCCode());
			stmt.setString(45, rae.getNonEMDFOPMaskedCCNbr());
			stmt.setString(46, rae.getNonEMDFOPCCExpryDt());
			stmt.setString(47, rae.getGroupCode());
			stmt.setString(48, rae.getSimultaneousTicketPurchaseInd());
			stmt.setString(49, rae.getCommissionInd());
			stmt.setString(50, rae.getInterlineInd());
			stmt.setString(51, rae.getFeeGuaranteedInd());
			stmt.setString(52, rae.getEMDPaperInd());
			stmt.setString(53, rae.getRFISubCode());
			stmt.setDate(54, rae.getRecordUpdateDate());
			stmt.setTime(55, rae.getRecordUpdateTime());
			stmt.setShort(56, rae.getIntraPNRSetNbr());
			stmt.setShort(57, rae.getPNRPassengerSeqId());
			stmt.setString(58, rae.getAEFLight());
			stmt.setString(59, rae.getAECurrentSegmentStatusCode());
			stmt.setString(60, rae.getAEPreviousSegmentStatus());
			stmt.setShort(61, rae.getACSCount());
			stmt.setShort(62, rae.getAssociatedSegmentCount());
			stmt.setTimestamp(63, utility.nowUtcTimestamp());
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
		ArrayList<ResAirExtra> resAirExtra = new ArrayList<ResAirExtra>();
		for (Object flight : flights) {
			resAirExtra.add((ResAirExtra) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResAirExtra.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResAirExtra res : resAirExtra) {
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
