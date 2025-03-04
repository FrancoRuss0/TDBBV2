//package com.airmalta.hip.tdbingester.sftp;
//
//import java.util.Arrays;
//
//import org.mule.api.endpoint.ImmutableEndpoint;
//import org.mule.transport.sftp.SftpReceiverRequesterUtil;
//
///**
// * An {@link SftpReceiverRequesterUtil} that sorts files according to the {@link DoneFileNameComparator}
// * 
// * @author jamesscicluna
// *
// */
//public class SortableSftpReceiverRequesterUtil extends SftpReceiverRequesterUtil {
//
//	public SortableSftpReceiverRequesterUtil(ImmutableEndpoint endpoint) {
//		super(endpoint);
//	}
//
//	/**
//	 * Overriding getAvailableFiles to first get all files in the standard way {@link SftpReceiverRequesterUtil} gets them,
//	 * after which they are sorted according to {@link DoneFileNameComparator}
//	 */
//	@Override
//	public String[] getAvailableFiles(boolean onlyGetTheFirstOne) throws Exception {
//
//		String[] availableFiles = super.getAvailableFiles(onlyGetTheFirstOne);
//		Arrays.sort(availableFiles, new DoneFileNameComparator());
//		return availableFiles;
//
//	}
//
//}
package com.kmmaltairlines.hip.tdbingester.sftp;
