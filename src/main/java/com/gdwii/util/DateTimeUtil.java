package com.gdwii.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class DateTimeUtil {
	private static final DateTimeFormatter yyyy_MM_dd_HH_mm_ss = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static String format(LocalDateTime dateTime){
		return yyyy_MM_dd_HH_mm_ss.format(dateTime);
	}
	
	public static LocalDateTime parse(String dateTime){
		return yyyy_MM_dd_HH_mm_ss.parse(dateTime, LocalDateTime::from);
	}
}
