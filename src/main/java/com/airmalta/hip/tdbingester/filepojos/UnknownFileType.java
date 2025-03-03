package com.airmalta.hip.tdbingester.filepojos;

import java.util.ArrayList;

/**
 * A POJO used to store data from an unknown file type (i.e. a .dat file received for which a 
 * .dwl transformation in src/main/resources/transformations does not exists and
 * a POJO in this package does not exist.
 * 
 * Currently, this POJO is not being used because when an unknown file is received, 
 * an {@link UnknownFileTypeException} is being thrown.
 * @author jamesscicluna
 *
 */
public class UnknownFileType {

	ArrayList<String> allFields = new ArrayList<String>();

	public ArrayList<String> getAllFields() {
		return allFields;
	}

	public void setAllFields(ArrayList<String> allFields) {
		this.allFields = allFields;
	}

}
