//package com.airmalta.hip.tdbingester.sftp;
//
//import org.mule.api.construct.FlowConstruct;
//import org.mule.api.endpoint.InboundEndpoint;
//import org.mule.api.lifecycle.CreateException;
//import org.mule.transport.sftp.SftpConnector;
//import org.mule.transport.sftp.SftpMessageReceiver;
//
///**
// * An overriding class of {@link SftpMessageReceiver} so that TDB Ingester polls on ONLY the primary node.
// * 
// * The reason for this is because:
// * 1) We want all TDB_Maintenance entries to be one after another rather than have them jumbled up.
// * 2) We do not want to have threads waiting for one Mule node to finish a DB transaction so that the second node
// *    can continue processing. This can easily happen when we receive a lot of files in one node and the secondary node
// *    will catch up to the first node.
// * 
// * If in the future another solution is found such that files can be processed concurrently by several nodes,
// * this class can be removed.
// * 
// * @author Justin Saliba
// */
//public class SinglePollingNodeSftpMessageReceiver extends SftpMessageReceiver {
//
//    public SinglePollingNodeSftpMessageReceiver(SftpConnector connector, FlowConstruct flow, InboundEndpoint endpoint,
//            long frequency) throws CreateException {
//        super(connector, flow, endpoint, frequency);
//    }
//
//    public SinglePollingNodeSftpMessageReceiver(SftpConnector connector, FlowConstruct flow, InboundEndpoint endpoint)
//            throws CreateException {
//        super(connector, flow, endpoint);
//    }
//
//    @Override
//    protected boolean pollOnPrimaryInstanceOnly() {
//        return true;
//    }
//
//}
package com.kmmaltairlines.hip.tdbingester.sftp;
