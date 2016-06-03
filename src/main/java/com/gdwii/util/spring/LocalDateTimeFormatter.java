package com.gdwii.util.spring;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.gdwii.util.DateTimeUtil;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {
	@Override
	public String print(LocalDateTime time, Locale locale) {
		return DateTimeUtil.format(time);
	}

	@Override
	public LocalDateTime parse(String text, Locale locale) throws ParseException {
		return DateTimeUtil.parse(text);
	}
}
