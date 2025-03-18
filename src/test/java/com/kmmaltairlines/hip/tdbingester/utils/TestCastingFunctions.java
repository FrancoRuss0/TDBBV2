package com.kmmaltairlines.hip.tdbingester.utils;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestCastingFunctions {
	
	private static String setNullOrTrim(String str){
		if (str.equalsIgnoreCase("")) {
			return null;
		} else {
			return str.trim();
		}
	}
	
	public static Date castToDate(String str, String format) throws ParseException{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		str = setNullOrTrim(str);
		return str == null ? null :  Date.valueOf(LocalDate.parse(str, dtf));
		
	}
	
	public static Time castToTime(String str, String format) throws ParseException{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		
		str = setNullOrTrim(str);
		return str == null ? null : Time.valueOf(LocalTime.parse(str, dtf));
	}
	
	public static Timestamp castToTimestamp(String str, String format) throws ParseException{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		
		str = setNullOrTrim(str);
		return str == null ? null : Timestamp.valueOf(LocalDateTime.parse(str, dtf));
	}
	
	public static Short castToShort(String str){
		str = setNullOrTrim(str);
		return str == null ? null : Short.parseShort(str);
	}
	
	public static BigDecimal castToBigDecimal(String str) throws ParseException{
		str = setNullOrTrim(str);
		return str == null ? null : new BigDecimal(str);
	}
	
	public static Byte castToByte(String str){
		str = setNullOrTrim(str);
		return str == null ? null : Byte.parseByte(str);
	}
	
	public static Integer castToInteger(String str){
		str = setNullOrTrim(str);
		return str == null ? null : Integer.parseInt(str);
	}
	
	public static String castToString(String str){
		return setNullOrTrim(str);
	}
	
}
