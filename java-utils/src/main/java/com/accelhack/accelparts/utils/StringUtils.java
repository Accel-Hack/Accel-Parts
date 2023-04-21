package com.accelhack.accelparts.utils;

public class StringUtils {

  /**
   * remove all whitespace of string
   * @param value string with no whitespace
   * @return result
   */
  public static String removeWhitespace(String value) {
    return value.replaceAll("\\s|　", "");
  }
}
