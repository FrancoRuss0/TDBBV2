package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktDocumentSql {

    @Autowired
    Utility utility;

    /**
     * Inserts a list of TktCoupon records into the database in bulk.
     * 
     * @param tktCoupons - List of TktCoupon objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<TktDocument> tktDocuments, Connection connection) throws SQLException, IOException {

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
        	stmt.setString(4, document.getAirlineAccountingCode());
        	stmt.setString(5, document.getEndDocNbr());
        	stmt.setString(6, document.getVendorName());
        	stmt.setString(7, document.getPointOfTktIssuance());
        	stmt.setString(8, document.getValidatingVendorCode());
        	stmt.setString(9, document.getValidatingVendorNbr());
        	stmt.setDate(10, document.getPNRPurgeDate());
        	stmt.setString(11, document.getCRSPNRLocator());
        	stmt.setDate(12, document.getDocIssueDate());
        	stmt.setString(13, document.getCustomerFullName());
        	stmt.setString(14, document.getAgentCountryCode());
        	stmt.setString(15, document.getIntlDocSaleCode());
        	stmt.setString(16, document.getTourCode());
        	stmt.setString(17, document.getAgentSine());
        	stmt.setString(18, document.getOwningCityCode());
        	stmt.setString(19, document.getAAACityCode());
        	stmt.setString(20, document.getDocIssueAAAIATANbr());
        	stmt.setString(21, document.getHomeCityCode());
        	stmt.setString(22, document.getRestrictions());
        	stmt.setString(23, document.getCurrConverRate());
        	stmt.setShort(24, document.getBankSellRate());
        	stmt.setShort(25, document.getBankBuyRate());
        	stmt.setShort(26, document.getIntlClearHouseRate());
        	stmt.setBigDecimal(27, document.getExchgTktAmt());
        	stmt.setString(28, document.getSettlementAuthCode());
        	stmt.setString(29, document.getBaseFareCurrCode());
        	stmt.setBigDecimal(30, document.getBaseFareAmt());
        	stmt.setString(31, document.getTotalFareCurrCode());
        	stmt.setBigDecimal(32, document.getTotalDocAmt());
        	stmt.setString(33, document.getEquivBaseFareCurrCode());
        	stmt.setBigDecimal(34, document.getEquivBaseFareAmt());
        	stmt.setString(35, document.getDataInd());
        	stmt.setString(36, document.getFareCalc());
        	stmt.setByte(37, document.getFareCalcType());
        	stmt.setDate(38, document.getOriginalIssueDate());
        	stmt.setString(39, document.getOriginalIssueCity());
        	stmt.setString(40, document.getOriginalIATANbr());
        	stmt.setString(41, document.getOriginalFOP());
        	stmt.setString(42, document.getOriginalTktNbr());
        	stmt.setString(43, document.getExchgFOP());
        	stmt.setString(44, document.getAddlExchgTktData());
        	stmt.setString(45, document.getExchgCoupon());
        	stmt.setString(46, document.getAutoPriceCode());
        	stmt.setString(47, document.getDocTypeCode());
        	stmt.setString(48, document.getDocStatusCode());
        	stmt.setString(49, document.getPassengerType());
        	stmt.setString(50, document.getSourceSystemId());
        	stmt.setString(51, document.getOACStationNbr());
        	stmt.setString(52, document.getRefundableInd());
        	stmt.setString(53, document.getCommissionableInd());
        	stmt.setString(54, document.getInterlineInd());
        	stmt.setString(55, document.getEMDRFICode());
        	stmt.setString(56, document.getEMDType());
        	stmt.setString(57, document.getTaxExInd());
        	stmt.setString(58, document.getConsumedAtIssueInd());
        	stmt.setString(59, document.getElectronicDocumentInd());
        	stmt.setString(60, document.getManualDocumentInd());
        	stmt.setString(61, document.getVoucherRefundInd());
        	stmt.setString(62, document.getRFICode());
        	stmt.setString(63, document.getRFITxt());
        	stmt.setString(64, document.getPTASvcChargeCurrCode());
        	stmt.setBigDecimal(65, document.getPTASvcChargeAmt());
        	stmt.setString(66, document.getPTAAddFundsDesc());
        	stmt.setString(67, document.getPTAAddFundsCurrCode());
        	stmt.setBigDecimal(68, document.getPTAAddFundsAmt());
        	stmt.setString(69, document.getExchgChangeFeeCurrCode());
        	stmt.setBigDecimal(70, document.getExchgChangeFeeAmt());
        	stmt.setString(71, document.getOtherFeeCurrCode());
        	stmt.setBigDecimal(72, document.getOtherFeeAmt());
        	stmt.setString(73, document.getAddCollectCurrCode());
        	stmt.setBigDecimal(74, document.getAddCollectAmt());
        	stmt.setString(75, document.getOACDefaultPartitionCode());
        	stmt.setString(76, document.getOACCityCode());
        	stmt.setString(77, document.getOACAcctCode());
        	stmt.setString(78, document.getNonRefFeeCurrCode());
        	stmt.setBigDecimal(79, document.getNonRefFeeAmt());
        	stmt.setString(80, document.getOBFeeDescText());
        	stmt.setString(81, document.getOBFeePricingCode());
        	stmt.setString(82, document.getOBFeeWaiverCode());
        	stmt.setString(83, document.getOBFeeTotalCurrCode());
        	stmt.setBigDecimal(84, document.getOBFeeTotal());
        	stmt.setBigDecimal(85, document.getOBFeeTotalUSD());
        	stmt.setString(86, document.getPricedPassengerType());
            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
