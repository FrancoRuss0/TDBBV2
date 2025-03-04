package com.kmmaltairlines.hip.tdbingester.processing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DeleteOnCloseFileInputStream extends FileInputStream {

	private static final Log log = LogFactory.getLog(DeleteOnCloseFileInputStream.class);

	private File file;

	public DeleteOnCloseFileInputStream(File file) throws FileNotFoundException {
		super(file);
		this.file = file;
	}

	@Override
	public void close() throws IOException {
		super.close();
		log.debug(String.format("Deleting file '%s'", file.getName()));

		FileUtils.deleteQuietly(file);
	}

	public File getFile() {
		return file;
	}

}
