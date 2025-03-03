package com.airmalta.hip.tdbingester.init;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.MuleRuntimeException;
import org.mule.api.context.notification.MuleContextNotificationListener;
import org.mule.context.notification.MuleContextNotification;
import org.springframework.beans.factory.annotation.Value;

/**
 * This class is used to ensure that the .enc file archive folder is present
 * when the application starts up. This also plays a role to ensure that Mule
 * has write permissions at the target directory prior to actually reading a 
 * file, attempting to save and thus failing.  
 * 
 * @author Justin Saliba
 */
public class MuleContextStartupListener implements MuleContextNotificationListener<MuleContextNotification> {

    @Value("${sftp.file.archive.dir}")
    private String encArchiveDir;

    private static final Log LOG = LogFactory.getLog(MuleContextStartupListener.class);

    public void onNotification(MuleContextNotification notification) {
        if (notification.getAction() == MuleContextNotification.CONTEXT_STARTING) {
            createDirectory(encArchiveDir);
        }
    }
    
    private void createDirectory(String directory) {
        try {
            LOG.info(String.format("Verifying directory '%s' exists", directory));
            Files.createDirectories(Paths.get(directory));
        } catch (FileAlreadyExistsException e) {
            throw new MuleRuntimeException(e);
        } catch (IOException e) {
            throw new MuleRuntimeException(e);
        } catch (SecurityException e) {
            throw new MuleRuntimeException(e);
        }
    }
}