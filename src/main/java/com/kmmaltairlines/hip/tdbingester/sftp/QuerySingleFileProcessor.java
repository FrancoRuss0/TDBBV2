package com.kmmaltairlines.hip.tdbingester.sftp;

//import java.io.IOException;
import java.io.InputStream;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.nio.ByteBuffer;
//import java.nio.charset.StandardCharsets;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.mule.api.DefaultMuleException;
//import org.mule.api.MuleContext;
//import org.mule.api.MuleEventContext;
//import org.mule.api.MuleException;
//import org.mule.api.context.MuleContextAware;
//import org.mule.api.endpoint.EndpointBuilder;
//import org.mule.api.endpoint.InboundEndpoint;
//import org.mule.api.lifecycle.Callable;
//import org.mule.api.lifecycle.Startable;
//import org.mule.config.i18n.MessageFactory;
//import org.mule.transport.sftp.SftpConnector;
//import org.mule.transport.sftp.SftpFileArchiveInputStream;
//import org.mule.transport.sftp.SftpInputStream;
//import org.mule.transport.sftp.SftpReceiverRequesterUtil;
//import org.mule.transport.sftp.notification.SftpNotifier;
//import org.mule.extension.sftp.internal.operation.SftpInputStream;

import com.google.common.io.CountingInputStream;
//import com.kmmaltairlines.hip.tdbingester.exceptions.EncFileDoesNotExistException;
//import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;

/**
 * 
 * This class programmatically uses the SFTP endpoint in the main flow to read
 * the .enc file from the SFTP corresponding the the current .done file stored
 * in the doneFile flow variable.
 * 
 * @author Justin Saliba
 *
 */
public class QuerySingleFileProcessor {

	// private static final Log logger =
	// LogFactory.getLog(QuerySingleFileProcessor.class);

	/**
	 * Reads DoneFile POJO from doneFile flowVariable, gets the corresponding .enc
	 * file name using getEncFileName(), uses programmatically the SFTP endpoint in
	 * the main flow to read the .enc file and, if found, returns it as a
	 * {@link com.google.common.io.CountingInputStream}. A CountingInputStream is
	 * needed in order to validate that the byte size of the .enc file is equal to
	 * the byte size denoted in the corresponding .done file.
	 */
	public Object onCall(InputStream inputStream) throws Exception {

//		DoneFile doneFile = (DoneFile) eventContext.getMessage().getInvocationProperty("doneFile");

//		SftpNotifier notifier = new SftpNotifier(sftpConnector, eventContext.getMessage(), endpoint, eventContext.getFlowConstruct().getName());

//		InputStream inputStream;
//		try {
//			inputStream = util.retrieveFile(doneFile.getEncFileName(), notifier);
//		}
//		catch (IOException e) {
//			// There’s no better way to do this unfortunately since Mule’s SFTP Util library does not propagate SFTP exceptions.
//			if (e.getMessage().contains("No such file")) {
//				// Throw an exception indicating that the .enc file corresponding to a DONE file was not found.
//				throw new EncFileDoesNotExistException(doneFile.getEncFileName(), doneFile, e);
//			}
//			throw new DefaultMuleException(MessageFactory.createStaticMessage("An IOException was thrown whilst attempting to download %s", doneFile.getEncFileName()), e);
//		}

		if (inputStream != null) {
//			SftpInputStream sftpInputStream = (SftpInputStream) inputStream;

			CountingInputStream countingInputStream = new CountingInputStream(inputStream);
			return countingInputStream;
		}

//		if (inputStream instanceof SftpFileArchiveInputStream) {
//			SftpFileArchiveInputStream sftpFileArchiveInputStream = (SftpFileArchiveInputStream) inputStream;
//			sftpFileArchiveInputStream.performPostProcessingOnClose(true);
//			
//			CountingInputStream countingInputStream = new CountingInputStream(sftpFileArchiveInputStream);
//			return countingInputStream;
//		}
//		
		throw new IllegalStateException(".gpg file inputStream resulted to null.");
	}

	/**
	 * On startup, get the necessary details to be able to retrieve files from the
	 * SFTP endpoint in the main flow programmatically through the onCall method
	 */
//    @Override
//    public void start() throws MuleException {
//        String encodedPassword;
//        try {
//            encodedPassword = URLEncoder.encode(password, "UTF-8");
//        }
//        catch (UnsupportedEncodingException ex) {
//            // There is extremely low probability chance of this actually happening ...
//            throw new DefaultMuleException("System does not support UTF-8 encoding. This is required to encode any special characters within the SFTP connector's password.", ex);
//        }
//        
//        String url = String.format("sftp://%s:%s@%s:%d/%s", username, encodedPassword, host, port, path.startsWith("/") ? path.substring(1) : path);
//        
//        EndpointBuilder endpointBuilder = muleContext.getEndpointFactory().getEndpointBuilder(url);
//        endpointBuilder.setConnector(this.sftpConnector);
//        InboundEndpoint inboundEndpoint = endpointBuilder.buildInboundEndpoint();
//        this.endpoint = inboundEndpoint;
//        
//        this.util = new SftpReceiverRequesterUtil(inboundEndpoint);
//    }
//	
//	@Override
//	public void setMuleContext(MuleContext context) {
//		this.muleContext = context;
//	}
//	
//	public void setHost(String host) {
//		this.host = host;
//	}
//
//	public void setPort(int port) {
//		this.port = port;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}
//
//	public void setConnector(SftpConnector connector) {
//		this.sftpConnector = connector;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

}