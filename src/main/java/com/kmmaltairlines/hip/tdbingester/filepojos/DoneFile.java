package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.Validate;

import com.kmmaltairlines.hip.tdbingester.exceptions.UnknownFileTypeException;

/**
 * POJO representing a .done file
 * 
 * @author jamesscicluna
 *
 */
public class DoneFile {

	private static final DateTimeFormatter DONEFILE_DATE_PATTERN = DateTimeFormatter.ofPattern("yyyyMMdd");
	private static final Pattern DATETIME_REGEX_PATTERN = Pattern.compile(".+_([\\d]{8})_.+");
	public static final Pattern DAT_FILE_NAME_PATTERN = Pattern.compile("^(.*)_(\\d{8})(_SPECIAL)?\\.dat$",
			Pattern.CASE_INSENSITIVE);
	public static final Pattern ENC_FILE_NAME_PATTERN = Pattern.compile("^km_(.*)_(\\d{8})(_SPECIAL)?_dat\\.enc$",
			Pattern.CASE_INSENSITIVE);
	public static final Pattern GPG_FILE_NAME_PATTERN = Pattern.compile("^km_(.*)_(\\d{8})(_SPECIAL)?_dat\\.zip.gpg$",
			Pattern.CASE_INSENSITIVE);

	private String timestamp;
	private String fileName;
	private long numberOfBytes;
	private List<DoneFileEntry> fileEntries;

	/**
	 * GPG_FILE_NAME_PATTERN Utility methods
	 */

	public LocalDate getTimestampAsLocalDate() {
		return LocalDate.parse(this.getTimestamp(), DONEFILE_DATE_PATTERN);
	}

	/**
	 * A utility method for other classes to parse .done file name without creating
	 * a DoneFile POJO
	 * 
	 * @param filename - a string obeying DATETIME_REGEX_PATTERN pattern and the 8
	 *                 numbers in the pattern follow the DONEFILE_DATE_PATTERN date
	 *                 format
	 * @return The date in the filename parsed as a LocalDate
	 */
	public static LocalDate getTimestampAsLocalDateFromDoneFilename(String filename) {
		return LocalDate.parse(getTimestampFromDoneFilename(filename), DONEFILE_DATE_PATTERN);
	}

	/**
	 * Construct .enc file name by using the .done file name without extension and
	 * apending the ".enc" file extension.
	 * 
	 * @return .enc file name, with ".enc" extension
	 */
	public String getEncFileName() {
		/*
		 * if (this.getFileNameWithoutExtension().toLowerCase().startsWith("km_epr") ||
		 * this.getFileNameWithoutExtension().toLowerCase().startsWith("km_ssi") ||
		 * this.getFileNameWithoutExtension().toLowerCase().startsWith("km_batch")) {
		 * return this.getFileNameWithoutExtension() + ".zip.gpg"; } else { return
		 * this.getFileNameWithoutExtension() + ".enc"; }
		 */
		return this.getFileNameWithoutExtension() + ".zip.gpg";
	}

	public DoneFile() {

	}

	/**
	 * 
	 * @return All the file names in the .done file as a set of strings.
	 */
	public Set<String> getFileEntryNames() {
		return fileEntries.stream().map(DoneFileEntry::getFilename).collect(Collectors.toSet());
	}

	/**
	 * 
	 * @param filename
	 * @return Returns true if filename is contained in the list of files specified
	 *         in the .done file.
	 */
	public boolean containsFile(String filename) {
		return this.getFileEntryNames().contains(filename);
	}

	/**
	 * 
	 * @param filenames A collection of filenames as strings.
	 * @return True whenever the .done file contains all the filenames in the given
	 *         collection, otherwise False.
	 */
	public boolean containsFiles(Collection<String> filenames) {
		return this.getFileEntryNames().containsAll(filenames);
	}

	/**
	 * Sets the filename and the timestamp of this .done file. Timestamp is
	 * extracted using the {@link getTimestampFromDoneFilename} method.
	 * 
	 * @param fileName
	 */
	public void setFileName(String fileName) {

		this.fileName = fileName;
		this.timestamp = getTimestampFromDoneFilename(fileName);
	}

	/**
	 * A utility method for other classes to parse .done file name without creating
	 * a DoneFile POJO
	 * 
	 * @param filename - a string obeying DATETIME_REGEX_PATTERN pattern
	 * @return A string of 8 numeric characters representing the date in the file
	 *         name.
	 */
	public static String getTimestampFromDoneFilename(String fileName) {
		Validate.matchesPattern(fileName, DATETIME_REGEX_PATTERN.pattern());
		Matcher matcher = DATETIME_REGEX_PATTERN.matcher(fileName);
		matcher.find();
		return matcher.group(1);
	}

	public EncFileType getEncFileType() throws UnknownFileTypeException {
		return EncFileType.fromEncFileName(getEncFileName());
	}

	/**
	 * 
	 * @return The .done file name as a string without the ".done" extension
	 */
	public String getFileNameWithoutExtension() {
		return FilenameUtils.removeExtension(fileName);
	}

	/**
	 * Standard getters and setters.
	 */

	public List<DoneFileEntry> getFileEntries() {
		return fileEntries;
	}

	public void setFileEntries(List<DoneFileEntry> fileEntries) {
		this.fileEntries = fileEntries;
	}

	public long getNumberOfBytes() {
		return numberOfBytes;
	}

	public void setNumberOfBytes(long numberOfBytes) {
		this.numberOfBytes = numberOfBytes;
	}

	public String getFileName() {
		return fileName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public enum EncFileType {

		ACS, EPR, BATCH;

		public static EncFileType fromEncFileName(String fileName) throws UnknownFileTypeException {

			Matcher matcher = ENC_FILE_NAME_PATTERN.matcher(fileName);
			if (matcher.find()) {
				String fileType = matcher.group(1).toLowerCase();

				if (fileType.contains("batch")) {
					return EncFileType.BATCH;
				}
				if (fileType.contains("epr")) {
					return EncFileType.EPR;
				}
				if (fileType.contains("acs")) {
					return EncFileType.ACS;
				}
			}

			matcher = GPG_FILE_NAME_PATTERN.matcher(fileName);
			if (matcher.find()) {
				String fileType = matcher.group(1).toLowerCase();

				if (fileType.contains("batch")) {
					return EncFileType.BATCH;
				}
				if (fileType.contains("epr")) {
					return EncFileType.EPR;
				}
				if (fileType.contains("acs")) {
					return EncFileType.ACS;
				}
			}

			throw new UnknownFileTypeException(
					String.format("Cannot determine file type from file name '%s'.", fileName));
		}
	}

}
