package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.EPR_Header;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class EPR_headerCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		EPR_Header payloadPojo = new EPR_Header();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof EPR_Header)
	        	payloadPojo = (EPR_Header) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not EPR_header.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of EPR_header.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getPCC_Cd(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getUser_Id(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getAccount_Cd(), TestCastingFunctions.castToString(linearr[2]));
			Assert.assertEquals(payloadPojo.getOffice_Cd(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getAgent_Sine(), TestCastingFunctions.castToString(linearr[4]));
			Assert.assertEquals(payloadPojo.getActive_Ind(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getAccess_Method_Txt(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getAgent_Last_Nm(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getAgent_Initial_Nm(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getHome_Office_Cd(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getHome_City_Txt(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getLast_Sign_in_Dt(), TestCastingFunctions.castToDate(linearr[11],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPIN_Set_Ind(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getPassword_Set_Ind(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getPIV_Questions_Ind(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getDuty_0_Cd_Ind(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getDuty_1_Cd_Ind(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getDuty_2_Cd_Ind(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getDuty_3_Cd_Ind(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getDuty_4_Cd_Ind(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getDuty_5_Cd_Ind(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getDuty_6_Cd_Ind(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getDuty_7_Cd_Ind(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getDuty_8_Cd_Ind(), TestCastingFunctions.castToString(linearr[23]));
			Assert.assertEquals(payloadPojo.getDuty_9_Cd_Ind(), TestCastingFunctions.castToString(linearr[24]));
			Assert.assertEquals(payloadPojo.getDuty_Hash_Cd_Ind(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getDuty_Dash_Cd_Ind(), TestCastingFunctions.castToString(linearr[26]));
			Assert.assertEquals(payloadPojo.getDuty_Star_Cd_Ind(), TestCastingFunctions.castToString(linearr[27]));
			Assert.assertEquals(payloadPojo.getDuty_Slash_Cd_Ind(), TestCastingFunctions.castToString(linearr[28]));
			Assert.assertEquals(payloadPojo.getDuty_Mesh_Cd_Ind(), TestCastingFunctions.castToString(linearr[29]));
			Assert.assertEquals(payloadPojo.getDuty_0_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[30]));
			Assert.assertEquals(payloadPojo.getDuty_1_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[31]));
			Assert.assertEquals(payloadPojo.getDuty_2_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[32]));
			Assert.assertEquals(payloadPojo.getDuty_3_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[33]));
			Assert.assertEquals(payloadPojo.getDuty_4_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[34]));
			Assert.assertEquals(payloadPojo.getDuty_5_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[35]));
			Assert.assertEquals(payloadPojo.getDuty_6_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[36]));
			Assert.assertEquals(payloadPojo.getDuty_7_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[37]));
			Assert.assertEquals(payloadPojo.getDuty_8_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[38]));
			Assert.assertEquals(payloadPojo.getDuty_9_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[39]));
			Assert.assertEquals(payloadPojo.getDuty_Hash_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[40]));
			Assert.assertEquals(payloadPojo.getDuty_Dash_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[41]));
			Assert.assertEquals(payloadPojo.getDuty_Star_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[42]));
			Assert.assertEquals(payloadPojo.getDuty_Slash_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[43]));
			Assert.assertEquals(payloadPojo.getDuty_Mesh_Temp_Cd_Ind(), TestCastingFunctions.castToString(linearr[44]));
			Assert.assertEquals(payloadPojo.getSCR_Group(), TestCastingFunctions.castToInteger(linearr[45]));
			Assert.assertEquals(payloadPojo.getRecordStatus(), TestCastingFunctions.castToString(linearr[46]));
			Assert.assertEquals(payloadPojo.getKeyword_Changed(), TestCastingFunctions.castToString(linearr[47]));
			Assert.assertEquals(payloadPojo.getEffectiveDate(), TestCastingFunctions.castToDate(linearr[48],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getMCP_Partition_Code(), TestCastingFunctions.castToString(linearr[49]));
			Assert.assertEquals(payloadPojo.getDefault_Ticketing_Carrier(), TestCastingFunctions.castToString(linearr[50]));
			Assert.assertEquals(payloadPojo.getStation_Code(), TestCastingFunctions.castToString(linearr[51]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in EPR_header file. Exception message: " + e.getMessage(), e);
		}

}


	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}