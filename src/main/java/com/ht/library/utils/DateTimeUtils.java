package com.ht.library.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class DateTimeUtils {
  private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";
  private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormat);

  public static Date dateFromString(String dateString) throws ParseException {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString);
  }

  public static LocalDateTime parseToLocalDateTime(String dateTimeString) {
    // Parse the string to LocalDateTime
    return LocalDateTime.parse(dateTimeString, dateTimeFormatter);
  }
}
