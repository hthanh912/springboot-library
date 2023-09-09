package com.ht.library.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateTimeUtils {
  public static Date dateFromString(String dateString) throws ParseException {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString);
  }
}
