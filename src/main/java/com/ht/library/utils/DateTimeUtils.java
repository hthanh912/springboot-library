package com.ht.library.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

  public static LocalDateTime timestampToLocalDateTime(String timestampString) {
    // Step 1: Convert the string to a long
    long timestampMillis = Long.parseLong(timestampString);

    // Step 2: Create an Instant
    Instant instant = Instant.ofEpochMilli(timestampMillis);

    // Step 3: Convert to LocalDateTime
    return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
  }
}
