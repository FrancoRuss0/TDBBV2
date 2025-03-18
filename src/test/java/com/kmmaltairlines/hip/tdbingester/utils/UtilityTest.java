package com.kmmaltairlines.hip.tdbingester.utils;


import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;

@Component
public class UtilityTest {
	
	
	public static DoneFile setDoneFile() {
		
		 DoneFile doneFile = new DoneFile();
	        doneFile.setFileName("km_cbatch_extract_20190101_dat.done");
	        doneFile.setNumberOfBytes(123);
	        doneFile.setFileEntries(Arrays.asList(
	            new DoneFileEntry("Res", 1),
	            new DoneFileEntry("TktDocument", 1)
	        ));
	        
	        return doneFile;
		
	}

}