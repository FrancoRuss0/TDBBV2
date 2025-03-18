import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.munit.assertions.*;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.TransformationIntoPOJO;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;


public class Transformations {
	
	@Test
	public void transformationToDoneFilePOJO() throws ClassNotFoundException, IOException {
		Utility utility = new Utility();
		File folder = new File("src/test/resources/");
		DoneFile doneFile= new DoneFile();
		ArrayList<DoneFileEntry> doneFileEntryList= new ArrayList<DoneFileEntry>();
		File[] fileList = folder.listFiles();
		for (File file : fileList) {
             String fileName = file.getName();

             // If the file is a ".done" file, proceed with processing
             if (fileName.endsWith(".done")) {
                 // Read the contents of the ".done" file 
                 ArrayList<String> readedFile = utility.readFile(file);

                 // Create a list of DoneFileEntry objects from the read data
                 doneFileEntryList = utility.createDoneFileEntry(readedFile);

                 // Create a DoneFile object containing metadata and data from the ".done" file
                  doneFile = utility.createDoneFile(fileName, readedFile, doneFileEntryList);
             }
		}
		assertEquals("Equals",1024,doneFile.getNumberOfBytes());
		assertTrue(doneFileEntryList.size()==3);
	}
	
	@Test
	public void transformationToResPOJO() throws ClassNotFoundException, IOException {
		String line="00|SUONMR|2017-10-24|2017-10-24 08:00:27.463000|TTY  ||N|0|1|LH |QYMISI|MUCLHQYMISI|1|KM|08:00:00||0|N||2018-06-04|0||2017-10-24|08:00:00|N||||||00000000|TTY|Y|N";
		DoneFileEntry fileEntry= new DoneFileEntry("Res",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResCustomAssertion Res= new ResCustomAssertion();
		Res.execute(array, line);
	}
	
	@Test
	public void transformationToResFlightPOJO() throws ClassNotFoundException, IOException {
		String line="01|XYSGDQ|2017-10-02|2017-10-02 08:31:51.561000|1|Y|N|N ||1|HK |NN |0|N|219|0515 |0515 |KM |||KM |N|N|N|N|VIE|2018-06-25|10:40:00|MLA|2018-06-25|12:50:00|IBM  ||N|||XS  |2017-10-02|07:35:00|1|2017-10-02|05:46:00||C|||     0|     0|N|N ||319|Airbus A319|";
		DoneFileEntry fileEntry= new DoneFileEntry("ResFlight",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResFlightCustomAssertion ResFlight= new ResFlightCustomAssertion();
		ResFlight.execute(array, line);
	}
	
	@Test
	public void transformationToResCarPOJO() throws ClassNotFoundException, IOException {
		String line="02|ABCDEF|2017-01-01|2017-11-01 12:00:15.123000|2|E|104959|35.00|CAD|22.50|9.90|100|TIAMZON JOCELYNMS|C|0428355 7US5|BOS|2011-01-23|23:10:00|HK|1|3|ZE|54.00|USD|DY|AUSC11 DOWNTOWN AUSTIN|0600HRS APTODEN|AS|2011-01-22|23:15:00|0";
		DoneFileEntry fileEntry= new DoneFileEntry("ResCar",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResCarCustomAssertion ResCar= new ResCarCustomAssertion();
		ResCar.execute(array, line);
	}
	
	@Test
	public void transformationToResHotelFTPOJO() throws ClassNotFoundException, IOException {
		String line="03|ABCDEF|2011-01-26|2011-04-27 12:21:15.123000|2|BOS|2011-03-19|3|1|HK|10|98775|HOLIDAY INN CITY CE|HI|A2Q|89.99|GOV|JPY|1DN623A|4283557|ASHIH ASHISHJ MR|CR5953|25.00|1|2|AS|2011-02-23|23:15:00|0";
		DoneFileEntry fileEntry= new DoneFileEntry("ResHotel",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResHotelCustomAssertion ResHotel= new ResHotelCustomAssertion();
		ResHotel.execute(array, line);
	}
	
	@Test
	public void transformationToResPassengerFTPOJO() throws ClassNotFoundException, IOException {
		String line="04|AFXSIQ|2017-08-23|2017-10-31 15:59:42.826000|1|1|FFT||618649065|INVLD ACCT NUMBER|NO||KM ||||||SK|AFF |2017-10-31|15:59:00|4";
		DoneFileEntry fileEntry= new DoneFileEntry("ResPassengerFT",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResPassengerFTCustomAssertion ResPassengerFT= new ResPassengerFTCustomAssertion();
		ResPassengerFT.execute(array, line);
	}
	
	@Test
	public void transformationToResRemarksPOJO() throws ClassNotFoundException, IOException {
		String line="05|XWJYAB|2017-10-02|2017-10-02 02:56:44.698000|1|*CA541984XXXXXX7898$08/18|15||||0";
		DoneFileEntry fileEntry= new DoneFileEntry("ResRemarks",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResRemarksCustomAssertion ResRemarks= new ResRemarksCustomAssertion();
		ResRemarks.execute(array, line);
	}
	
	@Test
	public void transformationToPreResSeatPOJO() throws ClassNotFoundException, IOException {
		String line="06|TTGKYA|2017-10-11|2017-10-11 12:59:01.116000|1|1|KM |2702 |2|0||PN |N|Y|N|Y|N|N|N|N|N|N|X4G*|2017-10-11|12:59:00|1";
		DoneFileEntry fileEntry= new DoneFileEntry("PreResSeat",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		PreResSeatCustomAssertion PreResSeat= new PreResSeatCustomAssertion();
		PreResSeat.execute(array, line);
	}
	
	@Test
	public void transformationToResPaxDocPOJO() throws ClassNotFoundException, IOException {
		String line="07|NLRTTU|2017-10-24|2017-10-24 16:19:00.674000|1|1|1966-12-17||DB|M|N||PAVEL||JAMES|N|||SSR|DOCS|A|1|HK||KM ||||0||";
		DoneFileEntry fileEntry= new DoneFileEntry("ResPaxDoc",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResPaxDocCustomAssertion ResPaxDoc= new ResPaxDocCustomAssertion();
		ResPaxDoc.execute(array, line);
	}
	
	@Test
	public void transformationToResSuspDocAgmtPOJO() throws ClassNotFoundException, IOException {
		String line="08|XYSGDQ|2017-10-02|2017-10-02 08:31:51.561000||2|||IBM  |ZAMMI/N|2017-10-02|14:36:00|4|BNZ|||TKT||TE |||6432459833504||||||||||0";
		DoneFileEntry fileEntry= new DoneFileEntry("ResSuspDocAgmt",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResSuspDocAgmtCustomAssertion ResSuspDocAgmt= new ResSuspDocAgmtCustomAssertion();
		ResSuspDocAgmt.execute(array, line);
	}
	
	@Test
	public void transformationToResSuspTimeLmtPOJO() throws ClassNotFoundException, IOException {
		String line="09|KEJBKH|2017-10-24|2017-10-24 04:45:55.036000|1|17:00|2017-10-24||||||0";
		DoneFileEntry fileEntry= new DoneFileEntry("ResSuspTimeLmt",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResSuspTimeLmtCustomAssertion ResSuspTimeLmt= new ResSuspTimeLmtCustomAssertion();
		ResSuspTimeLmt.execute(array, line);
	}
	
	@Test
	public void transformationToResEmergencyCtcPOJO() throws ClassNotFoundException, IOException {
		String line="10|SUONMR|2017-10-24|2017-10-24 08:00:27.463000|0|OSI|A||CTCT|1||||KM |SZG 00436462-3473 TOURISMUSSCHULEN SALZBURG GMBH||||0";
		DoneFileEntry fileEntry= new DoneFileEntry("ResEmergencyCtc",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResEmergencyCtcCustomAssertion ResEmergencyCtc= new ResEmergencyCtcCustomAssertion();
		ResEmergencyCtc.execute(array, line);
	}
	
	@Test
	public void transformationToResPassengerPOJO() throws ClassNotFoundException, IOException {
		String line="11|XYSGDQ|2017-10-02|2017-10-02 08:31:51.561000|1|NADIA MS|ZAMMIT||01.01 |XN  |2017-10-02|08:31:00|3";
		DoneFileEntry fileEntry= new DoneFileEntry("ResPassenger",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResPassengerCustomAssertion ResPassenger= new ResPassengerCustomAssertion();
		ResPassenger.execute(array, line);
	}
	
	@Test
	public void transformationToResSSRPOJO() throws ClassNotFoundException, IOException {
		String line="12|MPFAGM|2017-10-23|2017-10-23 21:22:22.671000|2|1|SSR|A|NN|478  |1|2017-11-23|KM|CKIN|/BAGS 1PC UP TO 23KG INCLUDED|R |||A4S |2017-10-23|21:22:00|3";
		DoneFileEntry fileEntry= new DoneFileEntry("ResSSR",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResSSRCustomAssertion ResSSR= new ResSSRCustomAssertion();
		ResSSR.execute(array, line);
	}
	
	@Test
	public void transformationToResTravelArrangerPOJO() throws ClassNotFoundException, IOException {
		String line="13|XYSGDQ|2017-10-02|2017-10-02 08:31:51.561000|AGENT|IBM  |4    |BNZ||IBM  |2017-10-02|08:31:00|3|ZAMMIT NADIA||||||00000000";
		DoneFileEntry fileEntry= new DoneFileEntry("ResTravelArranger",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResTravelArrangerCustomAssertion ResTravelArranger= new ResTravelArrangerCustomAssertion();
		ResTravelArranger.execute(array, line);
	}
	
	@Test
	public void transformationToResPassengerEmailPOJO() throws ClassNotFoundException, IOException {
		String line="14|MPFAGM|2017-10-23|2017-10-23 21:22:22.671000|1|maan.lee@datalex.com||||0|1";
		DoneFileEntry fileEntry= new DoneFileEntry("ResPassengerEmail",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResPassengerEmailCustomAssertion ResPassengerEmail= new ResPassengerEmailCustomAssertion();
		ResPassengerEmail.execute(array, line);
	}
	
	@Test
	public void transformationToResPassengerPhonePOJO() throws ClassNotFoundException, IOException {
		String line="15|XYSGDQ|2017-10-02|2017-10-02 08:31:51.561000|1|IBM|21662211-W|O ||||0";
		DoneFileEntry fileEntry= new DoneFileEntry("ResPassengerPhone",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResPassengerPhoneCustomAssertion ResPassengerPhone= new ResPassengerPhoneCustomAssertion();
		ResPassengerPhone.execute(array, line);
	}
	
	@Test
	public void transformationToResODFlightPOJO() throws ClassNotFoundException, IOException {
		String line="16|SUONMR|2017-10-24|2017-10-24 08:00:27.463000|1|MLA|MUC|MLA|VIE|MT |DE |MT |AT ";
		DoneFileEntry fileEntry= new DoneFileEntry("ResODFlight",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResODFlightCustomAssertion ResODFlight= new ResODFlightCustomAssertion();
		ResODFlight.execute(array, line);
	}
	
	@Test
	public void transformationToResAddressPOJO() throws ClassNotFoundException, IOException {
		String line="17|TZDTOK|2017-10-12|2017-10-12 09:23:17.631000|TEST|N|TEST|A|TEST|C|00000|Z||||||||1|0";
		DoneFileEntry fileEntry= new DoneFileEntry("ResAddress",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResAddressCustomAssertion ResAddress= new ResAddressCustomAssertion();
		ResAddress.execute(array, line);
	}
	
	@Test
	public void transformationToResDataIndexPOJO() throws ClassNotFoundException, IOException {
		String line="28|OCHYQC|2017-10-06|2017-10-31 08:34:56.435000|1|TRAVELER|948603|KM|||0|1|";
		DoneFileEntry fileEntry= new DoneFileEntry("ResDataIndex",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResDataIndexCustomAssertion ResDataIndex= new ResDataIndexCustomAssertion();
		ResDataIndex.execute(array, line);
	}
	
	@Test
	public void transformationToResTravelProtectionPOJO() throws ClassNotFoundException, IOException {
		String line="31|ABCDEF|2011-01-26|2011-04-27 12:21:15.123000|2|TB05|IG|2011-01-26|11|HB855745|HK|2011-10-29|2011-11-22|FRA|KUL|CC|VI|123400XXXXX9876|2015-01-31|USD|378.00|378.00|313.3378|2011-05-25|22:15:00|XS|0";
		DoneFileEntry fileEntry= new DoneFileEntry("ResTravelProtection",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResTravelProtectionCustomAssertion ResTravelProtection= new ResTravelProtectionCustomAssertion();
		ResTravelProtection.execute(array, line);
	}
	
	@Test
	public void transformationToResAirExtraPOJO() throws ClassNotFoundException, IOException {
		String line="32|ABDEF|2011-01-26|2011-04-27 12:21:15.123000|C|Large Dog in Cabin|N|ASVC|MNL|SIN|PR|ATP|01|AE|2|Y|1|1|YP|12345ABCD|H|1|2015-12-17|2015-12-25|UAX|2013-10-19 09:44:00.123000|2013-10-22 15:59:00.000000|05|1618201234567|1|1617271234567|1||For future use|01|100.00|MXN|10.00|USD|2|20|ADT|X|S|2012-12-17|22:45:31|For future use|For future use|For future use|BG|Y|Y|Y|T|E|BG9|2011-02-25|22:15:00|0|1|LA0126|HK|HD|99|99";
		DoneFileEntry fileEntry= new DoneFileEntry("ResAirExtra",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResAirExtraCustomAssertion ResAirExtra= new ResAirExtraCustomAssertion();
		ResAirExtra.execute(array, line);
	}
	
	@Test
	public void transformationToResAirExtraPortionofTravelPOJO() throws ClassNotFoundException, IOException {
		String line="36|ABCDEF|2015-01-26|0|2015-04-27 12:21:15.123000|2014-11-13 06:24:18.716000|24|1|1|SU|260|Y|2015-12-25|CGD|MOW|05921428984672|1|7252241566390|1|2014-11-13|2014-11-13 06:24:00|AF|AB|AM";
		DoneFileEntry fileEntry= new DoneFileEntry("ResAirExtraPortionofTravel",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResAirExtraPortionofTravelCustomAssertion ResAirExtraPortionofTravel= new ResAirExtraPortionofTravelCustomAssertion();
		ResAirExtraPortionofTravel.execute(array, line);
	}
	
	@Test
	public void transformationToResAirExtraTaxPOJO() throws ClassNotFoundException, IOException {
		String line="33|ABCDEF|2015-01-26|2015-04-27 12:21:15.123000|1|1|BG9|US2|3.50|2011-02-25|22:15:00|0";
		DoneFileEntry fileEntry= new DoneFileEntry("ResAirExtraTax",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResAirExtraTaxCustomAssertion ResAirExtraTax= new ResAirExtraTaxCustomAssertion();
		ResAirExtraTax.execute(array, line);
	}
	
	@Test
	public void transformationToResFlightAirExtraPOJO() throws ClassNotFoundException, IOException {
		String line="34|ABCDEF|2011-01-26|2011-04-27 12:21:15.123000|2|1|BG9|2011-02-25|22:15:00|0";
		DoneFileEntry fileEntry= new DoneFileEntry("ResFlightAirExtra",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ResFlightAirExtraCustomAssertion ResFlightAirExtra= new ResFlightAirExtraCustomAssertion();
		ResFlightAirExtra.execute(array, line);
	}
	
	@Test
	public void transformationToKRIPOJO() throws ClassNotFoundException, IOException {
		String line="18|CDQRTP|2017-05-27|6432159713154|2017-05-27|2017-10-30 15:38:00.000000|643|6432159713154|AIR MALTA|LQTAP|KM|643|||2017-05-27|HOLT/MARTIN|MT|||BAS|LQT|LQT||LQT|||0|0|0|||EUR|80.0000|EUR|157.3100||.0000||MLA KM LON42.32KM MLA42.32NUC84.64END ROE0.944989|5|||||||||0|TKT|A||KM|50490086||||||||Y|N|N||||.0000|||.0000||.0000||.0000||.0000||||EUR|80.0000|||||.0000||ADT";
		DoneFileEntry fileEntry= new DoneFileEntry("TktDocument",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktDocumentCustomAssertion TktDocument= new TktDocumentCustomAssertion();
		TktDocument.execute(array, line);
	}
	
	@Test
	public void transformationToTktCouponPOJO() throws ClassNotFoundException, IOException {
		String line="19|CXSIKB|2017-10-11|6432159995835|2017-10-11|2017-10-30 00:36:00.000000|1|1|USED|LFTD||KM|612|MLA|FCO|OK|2017-10-23|07:35:00.000000|2017-10-23|09:00:00.000000|N|NKMON1||Y|2017-10-23|2017-10-23||612|2017-10-23|MLA|FCO|M|2017-10-23||||39.4600|.0000|0|0||30778|KM|NUC||1PC";
		DoneFileEntry fileEntry= new DoneFileEntry("TktCoupon",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktCouponCustomAssertion TTktCouponktTax= new TktCouponCustomAssertion();
		TTktCouponktTax.execute(array, line);
	}
	
	@Test
	public void transformationToTktTaxPOJO() throws ClassNotFoundException, IOException {
		String line="20|LJAAUU|2017-10-30|6435912899344|2017-10-30|2017-10-30 09:19:00.000000|2|9.0000|CJ||NEW|GBP";
		DoneFileEntry fileEntry= new DoneFileEntry("TktTax",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktTaxCustomAssertion TktTax= new TktTaxCustomAssertion();
		TktTax.execute(array, line);
	}
	
	@Test
	public void transformationToTktTaxDetailPOJO() throws ClassNotFoundException, IOException {
		String line="21|PWEAIK|2017-10-05|0068661144372|2017-10-06|2017-10-06 01:15:00.000000|1|4.5000|XF|0|ATL";
		DoneFileEntry fileEntry= new DoneFileEntry("TktTaxDetail",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktTaxDetailCustomAssertion TktTaxDetail= new TktTaxDetailCustomAssertion();
		TktTaxDetail.execute(array, line);
	}
	
	@Test
	public void transformationToTktPaymentPOJO() throws ClassNotFoundException, IOException {
		String line="22|REKDFO|2017-10-30|1234567890123|2017-10-30|2017-10-30 07:49:00.000000|1|CC|54.6100|VI|1234A5XXXXXX6789|EUR|VI1234A5XXXXXX6789|123456|Z";
		DoneFileEntry fileEntry= new DoneFileEntry("TktPayment",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktPaymentCustomAssertion TktPayment= new TktPaymentCustomAssertion();
		TktPayment.execute(array, line);
	}
	
	@Test
	public void transformationToTktRemarkPOJO() throws ClassNotFoundException, IOException {
		String line="23|NHKZVA|2017-09-27|6432160035531|2017-10-30|2017-10-30 03:39:00.000000|1|AUTH 081135/3031/30102017/44/33";
		DoneFileEntry fileEntry= new DoneFileEntry("TktRemark",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktRemarkCustomAssertion TktRemark= new TktRemarkCustomAssertion();
		TktRemark.execute(array, line);
	}
	
	@Test
	public void transformationToTktAddressPOJO() throws ClassNotFoundException, IOException {
		String line="24|UOYPOB|2017-10-03|6432460018518|2017-10-21|2017-10-30 00:36:00.000000|3|HERTFORDSHIRE, HERTFORDSHIRE";
		DoneFileEntry fileEntry= new DoneFileEntry("TktAddress",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktAddressCustomAssertion TktAddress= new TktAddressCustomAssertion();
		TktAddress.execute(array, line);
	}
	
	@Test
	public void transformationToTktDocumentHistoryPOJO() throws ClassNotFoundException, IOException {
		String line="25|ABALIA|2017-10-23|6435669449544|2017-10-23|2017-10-23 08:00:00.000000|5|USE|MLA|MLA|7|MRM|2017-10-23|08:00:00.000000|ABALIA||||6435669449544|KM|KM|0|0|0||||||";
		DoneFileEntry fileEntry= new DoneFileEntry("TktDocumentHistory",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktDocumentHistoryCustomAssertion TktDocumentHistory= new TktDocumentHistoryCustomAssertion();
		TktDocumentHistory.execute(array, line);
	}
	
	@Test
	public void transformationToTktCouponHistoryPOJO() throws ClassNotFoundException, IOException {
		String line="26|KTLEHD|2017-10-30|6432160036208|2017-10-30|2017-10-31 03:57:00.000000|1||1|||1|||KM|C|100|2017-11-04|MLA|LHR|07:55:00.000000|10:25:00.000000|OK|2017-10-31|03:57:00|7";
		DoneFileEntry fileEntry= new DoneFileEntry("TktCouponHistory",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktCouponHistoryCustomAssertion TktCouponHistory= new TktCouponHistoryCustomAssertion();
		TktCouponHistory.execute(array, line);
	}
	
	@Test
	public void transformationToTktEndorsementPOJO() throws ClassNotFoundException, IOException {
		String line="27|HUANYB|2017-06-26|6435912638179|2017-10-20|2017-10-30 04:54:00.000000|1|GBP170.00 NONREF - VALID KM FARES ONLY NON-END / NO REFUND ADD FEE FOR CHANGES";
		DoneFileEntry fileEntry= new DoneFileEntry("TktEndorsement",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktEndorsementCustomAssertion TktEndorsement= new TktEndorsementCustomAssertion();
		TktEndorsement.execute(array, line);
	}
	
	@Test
	public void transformationToTktProRationPOJO() throws ClassNotFoundException, IOException {
		String line="29|EPNIQF|2017-09-24|0552335367937|2017-09-24|2017-11-01 08:58:00.000000|1|693.2760|431.0631|1.0000|70.2800|156.8700|JPY|113.8304|8000.0000|17856.5748|EUR|59.0000|131.7000";
		DoneFileEntry fileEntry= new DoneFileEntry("TktProRation",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktProRationCustomAssertion TktProRation= new TktProRationCustomAssertion();
		TktProRation.execute(array, line);
	}
	
	@Test
	public void transformationToTktMSRPOJO() throws ClassNotFoundException, IOException {
		String line="30|EVBGQS|2017-08-29|6430610069920|2017-11-01|2017-11-01 00:00:00.000000|1|1|098|NONREF103/11NOV 05AB|EUR|30.00000000|.00000000||KM||";
		DoneFileEntry fileEntry= new DoneFileEntry("TktMSR",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktMSRCustomAssertion TktMSR= new TktMSRCustomAssertion();
		TktMSR.execute(array, line);
	}
	
	@Test
	public void transformationToTktCouponEMDPOJO() throws ClassNotFoundException, IOException {
		String line="35|ABCDEF|2017-09-24|6430610069920|2017-11-01|2011-02-12 08:21:15.123000|1|MN|BG|C|1|BG9|Large Dog in Cabin|EMDA|Y|ATP|S|1612301234567|2|2012-11-28";
		DoneFileEntry fileEntry= new DoneFileEntry("TktCouponEMD",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktCouponEMDCustomAssertion TktCouponEMD= new TktCouponEMDCustomAssertion();
		TktCouponEMD.execute(array, line);
	}
	
	@Test
	public void transformationToTKTFeesPOJO() throws ClassNotFoundException, IOException {
		String line="37|1065305223445|2016-02-06|2011-02-12 08:21:15.456000|SY|1|OBT|OTH|EUR|15.00|17.04|N|OBF01|N|Overnight Delivery Charge|0|01";
		DoneFileEntry fileEntry= new DoneFileEntry("TKTFees",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TKTFeesCustomAssertion TKTFees= new TKTFeesCustomAssertion();
		TKTFees.execute(array, line);
	}
	
	@Test
	public void transformationToTktDocumentKRI5POJO() throws ClassNotFoundException, IOException {
		String line="18|ABCDEF|2018-05-27|6432112345678|2017-05-27|2017-10-30 15:38:00.123000|643|6432159713154|AIR MALTA|LQTAP|KM|643|||2017-05-27|HOLT/MARTIN|MT|||BAS|LQT|LQT||LQT|||0|0|0|||EUR|80.0000|EUR|157.3100||.0000||MLA KM LON42.32KM MLA42.32NUC84.64END ROE0.944989|5|||||||||0|TKT|A||KM|50490086||||||||Y|N|N||||.0000|||.0000||.0000||.0000||.0000||||EUR|80.0000|||||.0000||ADT";
		DoneFileEntry fileEntry= new DoneFileEntry("TktDocument",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		TktDocumentCustomAssertion TktDocument= new TktDocumentCustomAssertion();
		TktDocument.execute(array, line);
	}
	
	@Test
	public void transformationToEPR_HeaderPOJO() throws ClassNotFoundException, IOException {
		String line="KM|88888|||BCA|T|Human|CELEBI AUSTRIA|A|0000|YWD|2017-11-09|0|1|0|0|0|0|0|1|0|0|1|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|I|Y|2017-11-10|||";
		DoneFileEntry fileEntry= new DoneFileEntry("EPR_Header",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		EPR_headerCustomAssertion EPR_Header= new EPR_headerCustomAssertion();
		EPR_Header.execute(array, line);
	}
	
	@Test
	public void transformationToEPR_KeywordPOJO() throws ClassNotFoundException, IOException {
		String line="KM|88888|24TIME|I|2017-11-10";
		DoneFileEntry fileEntry= new DoneFileEntry("EPR_Keyword",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		EPR_keywordCustomAssertion EPR_Keyword= new EPR_keywordCustomAssertion();
		EPR_Keyword.execute(array, line);
	}
	
	@Test
	public void transformationToEPR_OACPOJO() throws ClassNotFoundException, IOException {
		String line="KM|1648|LA|HDQ|AG|8990201|1|2011-05-10";
		DoneFileEntry fileEntry= new DoneFileEntry("EPR_OAC",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		EPR_OACCustomAssertion EPR_OAC= new EPR_OACCustomAssertion();
		EPR_OAC.execute(array, line);
	}
	
	@Test
	public void transformationToACSFlightPOJO() throws ClassNotFoundException, IOException {
		String line="KM|KM|0100|2017-09-27|MLA|LHR|MLA|LHR||N|N|N|N||2017-09-27|09:45:00|2017-09-27|07:20:00|2017-09-27|07:20:00|2017-09-27|09:45:00|2017-09-27|11:57:00|2017-09-27|11:57:00|N|17||2017-09-27 04:59:38|320|005|4|||||||||";
		DoneFileEntry fileEntry= new DoneFileEntry("ACSFlight",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ACSFlightCustomAssertion acsFlight= new ACSFlightCustomAssertion();
		acsFlight.execute(array, line);
	}
	
	@Test
	public void transformationToACSPaxFlightPOJO() throws ClassNotFoundException, IOException {
		String line="KM|XAFLVC|XAFLVC|2017-09-12|2017-09-12|1|KM|0100|2017-09-27|MLA|1 |FIRST DR|SURNAME SENIOR|MLA|LHR|XAFLVC001|F|Y|N|N|N|N|N|N|||M |S |N|KM |0100|KM|0100|N|N|N|N|N|N|N||N|N|N|N|N|Y|N|N|N|N|N|N|N|N||1||1||N|N|N|N|N|||N|||||||||||N|||||N|N|N|N|N|N|N|N|N|N|N|N|N|2017-09-27 04:59:38|N||||||||||||||||||";
		DoneFileEntry fileEntry= new DoneFileEntry("ACSPaxFlight",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ACSPaxFlightCustomAssertion acsPaxFlight= new ACSPaxFlightCustomAssertion();
		acsPaxFlight.execute(array, line);
	}
	
	@Test
	public void transformationToACSPaxVCRPOJO() throws ClassNotFoundException, IOException {
		String line="KM|VVALVQ|2017-09-26|1|KM|0100|2017-09-27|MLA|2017-09-26|643|2459833299   |1|S|SKMON1       |N|N|N||N|N|Y|N|N|N|N|||||||||N||2017-09-27 04:59:38";
		DoneFileEntry fileEntry= new DoneFileEntry("ACSPaxVCR",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ACSPaxVCRCustomAssertion ACSPaxVCR= new ACSPaxVCRCustomAssertion();
		ACSPaxVCR.execute(array, line);
	}
	
	@Test
	public void transformationToACSPaxDOCXPOJO() throws ClassNotFoundException, IOException {
		String line="KM|VVFSSX|2017-09-26|1|KM|0100|2017-09-27|MLA|Y|N|N||N|N|||||||||N|N|N|N|P |N|MT |173538|MT |20SEP1982      |F|19SEP2022      |NINA MS||SIMONE|N|N|MT|MLT|MT|MLT|2017-09-27 04:59:38|||||||||";
		DoneFileEntry fileEntry= new DoneFileEntry("ACSPaxDOCX",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ACSPaxDOCXCustomAssertion ACSPaxDOCX= new ACSPaxDOCXCustomAssertion();
		ACSPaxDOCX.execute(array, line);
	}
	
	@Test
	public void transformationToACSPaxSeatPOJO() throws ClassNotFoundException, IOException {
		String line="KM|VVFSSX|2017-09-26|1|KM|0100|2017-09-27|MLA|M|19 |D|N|||||N|N|N|N|N|2017-09-27 04:59:38";
		DoneFileEntry fileEntry= new DoneFileEntry("ACSPaxSeat",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ACSPaxSeatCustomAssertion ACSPaxSeat= new ACSPaxSeatCustomAssertion();
		ACSPaxSeat.execute(array, line);
	}
	
	@Test
	public void transformationToACSPaxBagPOJO() throws ClassNotFoundException, IOException {
		String line="KM|VVALVQ|2017-09-26|1|KM|0100|2017-09-27|MLA|5643794483|13:04:00|2017-09-26|N|N|Y|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|N|||||||001|NGV|4|MLA|13:04:00|2017-09-26|2017-09-27|||||KM|||||0100|||||MLA|||||LHR|||||||||||||||||||||||||||||||||||||2017-09-27 04:59:38";
		DoneFileEntry fileEntry= new DoneFileEntry("ACSPaxBag",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ACSPaxBagCustomAssertion ACSPaxBag= new ACSPaxBagCustomAssertion();
		ACSPaxBag.execute(array, line);
	}
	
	@Test
	public void transformationToACSFlightHistoryPOJO() throws ClassNotFoundException, IOException {
		String line="KM|2017-09-27|KM|0100|MLA|LHR  |07:20:00|MLA|SYS    |2017-09-27|04:58:00|000000|API/KM0100/27SEPMLALHR 2811-$INVALID CITY FOR CUSTOMS LIST|||2017-09-27 04:59:38";
		DoneFileEntry fileEntry= new DoneFileEntry("ACSFlightHistory",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ACSFlightHistoryCustomAssertion ACSFlightHistory= new ACSFlightHistoryCustomAssertion();
		ACSFlightHistory.execute(array, line);
	}
	
	@Test
	public void transformationToACSPaxHistoryPOJO() throws ClassNotFoundException, IOException {
		String line="KM|2017-09-27|KM|0100|MLA  |QGDDQE|SURNAME SE|FIRST|LHR  |2017-09-27|07:20:00|MLA|000|2017-09-27|04:58:00|000000|PNRUPD/KM0100/27SEPMLALHR/18A0811E|||0  ||5|MLA  |1|2|||N|N|N|N|2017-09-27 04:59:38|N|N|N|N";
		DoneFileEntry fileEntry= new DoneFileEntry("ACSPaxHistory",1);
		
		TransformationIntoPOJO load= new TransformationIntoPOJO();
		
		ArrayList<Object>array=load.loadDatFileIntoPOJO(line, fileEntry.getFilename());
		ACSPaxHistoryCustomAssertion ACSPaxSeat= new ACSPaxHistoryCustomAssertion();
		ACSPaxSeat.execute(array, line);
	}
}
