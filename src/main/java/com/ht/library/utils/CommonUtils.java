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

  public static Integer[] convertToIntegerArray(String histogram) {
    if (histogram == null || histogram.isEmpty()) {
      return new Integer[0]; // Return an empty array if input is null or empty
    }

    // Remove brackets and split by commas
    histogram = histogram.replaceAll("\\[", "").replaceAll("\\]", "").trim();
    String[] stringArray = histogram.split(",");

    // Convert to Integer array
    Integer[] intArray = new Integer[stringArray.length];
    for (int i = 0; i < stringArray.length; i++) {
      intArray[i] = Integer.parseInt(stringArray[i].trim()); // Parse each string to Integer
    }

    return intArray;
  }
}
