package com.kmmaltairlines.hip.tdbingester.processing;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.IOUtils;
import org.mule.api.MuleMessage;
import org.mule.api.MuleRuntimeException;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.config.i18n.MessageFactory;
import org.mule.routing.filters.WildcardFilter;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transformer.types.SimpleDataType;
import org.mule.transport.file.filters.FilenameRegexFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.google.common.io.CountingInputStream;
import com.google.common.io.Files;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile.EncFileType;

/**
 * Extracts the files in a zip-file and places them in a {@link List} of
 * {@link InputStream}s. Expects the zip-file as byte-array or an inputStream.
 * 
 * This class is a heavily modified version of Magnus Larsson's and Pontus
 * Ullgren's implementation of UnzipTransformer. The original can be found here:
 * https://gist.github.com/ullgren/3a8d924b8e5c7320eb4f
 * 
 * @author Justin Saliba
 */
public class UnzipTransformer extends AbstractMessageTransformer {

	private static final Logger log = LoggerFactory.getLogger(UnzipTransformer.class);

	private WildcardFilter filter = new FilenameRegexFilter();

	public UnzipTransformer() {
		registerSourceType(new SimpleDataType<Object>(InputStream.class));
		registerSourceType(new SimpleDataType<Object>(byte[].class));
		setReturnDataType(new SimpleDataType<Object>(Map.class));

		// match every file by default in a case sensitive fashion
		filter.setPattern(".*");
		filter.setCaseSensitive(true);
	}

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		Object payload = message.getPayload();

		Map<String, File> resultList = new HashMap<>();

		InputStream is = null;
		if (payload instanceof InputStream) {
			is = (InputStream) payload;
		} else if (payload instanceof byte[]) {
			is = new ByteArrayInputStream((byte[]) payload);
		} else {
			throw new MuleRuntimeException(MessageFactory.createStaticMessage(
					"Unsupported payload type: %s. Only %s and %s payload types are supported.",
					payload.getClass().getName(), InputStream.class.getName(), byte[].class.getName()));
		}

		try (ZipInputStream zis = new ZipInputStream(is)) {

			ZipEntry entry = null;

			long totalUncompressedBytes = 0;

			while ((entry = zis.getNextEntry()) != null) {
				String name = entry.getName();

				totalUncompressedBytes += entry.getSize();

				// Skip folders...
				if (entry.isDirectory()) {
					log.debug("Skipping folder '{}'", name);
					continue;
				}

				// Does the file pass the filename filter?
				log.debug("Checking ZIP file name '{}' against wildcard '{}'", name, filter.getPattern());
				if (!filter.accept(name)) {
					log.debug("Skipping file '{}' since it did not match filename pattern '{}'", name,
							filter.getPattern());
					continue;
				}

				int lastDirSep = name.lastIndexOf('/');
				if (lastDirSep != -1) {
					log.debug("unzip strips zip-folderpath " + name.substring(0, lastDirSep));
					name = name.substring(lastDirSep + 1);
				}

				File tmpDir = Files.createTempDir();
				File datFile = new File(tmpDir, name);

				// write the current file to disk
				try (FileOutputStream fos = new FileOutputStream(datFile)) {
					IOUtils.copy(zis, fos);

					Matcher matcher = DoneFile.DAT_FILE_NAME_PATTERN.matcher(name);
					matcher.find();

					String filename = matcher.group(1);

					resultList.put(filename, datFile);
				}
			}

			// This property is only ever used for ACS files since expect the number of
			// bytes in their respective done file
			// is expected to be equal to the sum of uncompressed bytes of all the extracted
			// files, but it's good to have it
			// on the mule message in any case.

			message.setProperty("totalUncompressedBytes", totalUncompressedBytes, PropertyScope.INVOCATION);

		} catch (Exception e) {
			throw new TransformerException(MessageFactory.createStaticMessage("Failed to uncompress file."), this, e);
		}

		return resultList;
	}

	public void setFilenamePattern(String pattern) {
		filter.setPattern(pattern);
	}

	public void setCaseSensitive(boolean caseSensitive) {
		filter.setCaseSensitive(caseSensitive);
	}
}