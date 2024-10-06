package com.ht.library.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class CommonUtils {

  public static String stringToSnakeCase(String s) {
    String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    return pattern.matcher(temp).replaceAll("")
        .replaceAll("\\s+", "_")
        .replace('đ','d')
        .replace('Đ','D')
        .toLowerCase();
  }

  public static String removeRedundantSpaces(String s) {
    return s.trim().replaceAll("\\s+", " ");
  }

}
