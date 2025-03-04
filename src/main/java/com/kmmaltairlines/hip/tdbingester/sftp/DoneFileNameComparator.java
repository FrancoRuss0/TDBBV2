package com.kmmaltairlines.hip.tdbingester.sftp;

import java.time.LocalDate;
import java.util.Comparator;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;

/**
 * Comparator used by {@link SortableSftpReceiverRequesterUtil} to sort .done
 * files from newest to oldest based upon the timestamp in the .done file's name
 * 
 * @author Justin Saliba
 */
public class DoneFileNameComparator implements Comparator<String> {

	@Override
	public int compare(String lhs, String rhs) {

		LocalDate lhsDate = DoneFile.getTimestampAsLocalDateFromDoneFilename(lhs);
		LocalDate rhsDate = DoneFile.getTimestampAsLocalDateFromDoneFilename(rhs);
		return (lhsDate.compareTo(rhsDate)) * -1;

	}

}
