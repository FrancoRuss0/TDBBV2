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
			stmt.setString(2, rae.getPNRLocatorID());
			stmt.setDate(3, rae.getPNRCreateDate());
			stmt.setTimestamp(4, rae.getFromDateTime());
			stmt.setString(5, rae.getRFICode());
			stmt.setString(6, rae.getCommercialName());
			stmt.setString(7, rae.getSSIMCode());
			stmt.setString(8, rae.getSSRCode());
			stmt.setString(9, rae.getBoardPointAirportCode());
			stmt.setString(10, rae.getOffPointAirportCode());
			stmt.setString(11, rae.getOwningCarrierCode());
			stmt.setString(12, rae.getFeeVendorCode());
			stmt.setString(13, rae.getBookingMethodCode());
			stmt.setString(14, rae.getFulfillTypeCode());
			stmt.setShort(15, rae.getEMDTypeCode());
			stmt.setString(16, rae.getRefundReissueCode());
			stmt.setString(17, rae.getFormOfRefundCode());
			stmt.setString(18, rae.getFrequentTravelerTierLevel());
			stmt.setString(19, rae.getBrandedFareId());
			stmt.setString(20, rae.getTourCode());
			stmt.setString(21, rae.getServiceChargeCode());
			stmt.setString(22, rae.getFeeApplicationCode());
			stmt.setDate(23, rae.getFirstTravelDate());
			stmt.setDate(24, rae.getLastTravelDate());
			stmt.setString(25, rae.getHistoryActionCode());
			stmt.setTimestamp(26, rae.getTTYConfirmationDateTime());
			stmt.setTimestamp(27, rae.getPurchaseByDateTime());
			stmt.setString(28, rae.getBookingSourceCode());
			stmt.setString(29, rae.getEMDNbr());
			if (rae.getEMDCouponNbr() == null) {
				stmt.setNull(30, Types.NULL);
			} else {
				stmt.setShort(30, rae.getEMDCouponNbr());
			}
			stmt.setString(31, rae.getETicketNbr());
			if (rae.getETicketCouponNbr() == null) {
				stmt.setNull(32, Types.NULL);
			} else {
				stmt.setShort(32, rae.getETicketCouponNbr());
			}
			stmt.setString(33, rae.getSSRDirectFulfillCode());
			stmt.setString(34, rae.getNonEMDFormofPayment());
			stmt.setString(35, rae.getFeeWaivedCode());
			stmt.setBigDecimal(36, rae.getAEBasePriceAmount());
			stmt.setString(37, rae.getAEBaseCurrencyCode());
			stmt.setBigDecimal(38, rae.getAEEquivalentPaidAmount());
			stmt.setString(39, rae.getAEEquivalentAmtCurrencyCd());
			if (rae.getItemCount() == null) {
				stmt.setNull(40, Types.NULL);
			} else {
				stmt.setShort(40, rae.getItemCount());
			}

			stmt.setBigDecimal(41, rae.getAETotalPriceAmount());
			stmt.setString(42, rae.getPassengerTypeCode());
			stmt.setString(43, rae.getTaxIncludedCode());
			stmt.setString(44, rae.getSegmentUseCode());
			stmt.setDate(45, rae.getSegmentBookedDate());
			stmt.setTime(46, rae.getSegmentBookedTime());
			stmt.setString(47, rae.getNonEMDFOPCCCode());
			stmt.setString(48, rae.getNonEMDFOPMaskedCCNbr());
			stmt.setString(49, rae.getNonEMDFOPCCExpryDt());
			stmt.setString(50, rae.getGroupCode());
			stmt.setString(51, rae.getSimultaneousTicketPurchaseInd());
			stmt.setString(52, rae.getCommissionInd());
			stmt.setString(53, rae.getInterlineInd());
			stmt.setString(54, rae.getFeeGuaranteedInd());
			stmt.setString(55, rae.getEMDPaperInd());
			stmt.setString(56, rae.getRFISubCode());
			stmt.setDate(57, rae.getRecordUpdateDate());
			stmt.setTime(58, rae.getRecordUpdateTime());
			if (rae.getIntraPNRSetNbr() == null) {
				stmt.setNull(59, Types.NULL);
			} else {
				stmt.setShort(59, rae.getIntraPNRSetNbr());
			}

			if (rae.getPNRPassengerSeqId() == null) {
				stmt.setNull(60, Types.NULL);
			} else {
				stmt.setShort(60, rae.getPNRPassengerSeqId());
			}
			stmt.setString(61, rae.getAEFLight());
			stmt.setString(62, rae.getAECurrentSegmentStatusCode());
			stmt.setString(63, rae.getAEPreviousSegmentStatus());
			if (rae.getPNRPassengerSeqId() == null) {
				stmt.setNull(60, Types.NULL);
			} else {
				stmt.setShort(60, rae.getPNRPassengerSeqId());
			}
			stmt.setShort(64, rae.getACSCount());
			if (rae.getAssociatedSegmentCount() == null) {
				stmt.setNull(65, Types.NULL);
			} else {
				stmt.setShort(65, rae.getAssociatedSegmentCount());
			}

			stmt.setTimestamp(66, utility.nowUtcTimestamp());
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
