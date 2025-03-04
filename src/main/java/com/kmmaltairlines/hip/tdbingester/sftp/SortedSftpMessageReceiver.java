//package com.airmalta.hip.tdbingester.sftp;
//
//import org.mule.api.construct.FlowConstruct;
//import org.mule.api.endpoint.InboundEndpoint;
//import org.mule.api.lifecycle.CreateException;
//import org.mule.transport.sftp.SftpConnector;
//import org.mule.transport.sftp.SftpMessageReceiver;
//import org.mule.transport.sftp.SftpReceiverRequesterUtil;
//
///**
// * A custom implementation of {@link SftpMessageReceiver} which simply overrides
// * a method so that a custom {@link SftpReceiverRequesterUtil} is created. This
// * will allow us to read SFTP files in any order we like, depending on the
// * implementation of
// * {@link SftpReceiverRequesterUtil#getAvailableFiles(boolean)}
// * 
// * Moreover, this class inherits from {@link SinglePollingNodeSftpMessageReceiver} so that 
// * only one node is ever polls for new files at any one time.
// * 
// * @author Justin Saliba
// */
//public class SortedSftpMessageReceiver extends SinglePollingNodeSftpMessageReceiver {
//
//	public SortedSftpMessageReceiver(SftpConnector connector, FlowConstruct flow, InboundEndpoint endpoint,
//			long frequency) throws CreateException {
//		super(connector, flow, endpoint, frequency);
//	}
//
//	/**
//	 * Creates a new implementation of {@link SortableSftpReceiverRequesterUtil}
//	 * 
//	 * @param endpoint
//	 *            The {@link InboundEndpoint} with which to create the
//	 *            {@link SortableSftpReceiverRequesterUtil}
//	 * @return An instance of {@link SortableSftpReceiverRequesterUtil}
//	 */
//	@Override
//	protected SftpReceiverRequesterUtil createSftpReceiverRequesterUtil(InboundEndpoint endpoint) {
//		return new SortableSftpReceiverRequesterUtil(endpoint);
//	}
//
//}
package com.kmmaltairlines.hip.tdbingester.sftp;
