package com.ht.library.utils;

public class CommonUtils {
  public static String spaceToUnderScore(String string) {
    return string.replaceAll("\\s+", "_").toLowerCase();
  }
}
