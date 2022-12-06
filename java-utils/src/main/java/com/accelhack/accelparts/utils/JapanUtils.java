package com.accelhack.accelparts.utils;

import java.util.regex.Pattern;

public class JapanUtils {
  /**
   * check if string only contains zenkaku katakana
   * @param value string to check
   * @return result
   */
  public static boolean isZenkakuKatakana(String value) {
    String katakanaInput = value.replace(" ", "");
    if (katakanaInput.equals("")) {
      return true; // 空文字ならOKとする.
    }
    String regex = "^[ァ-ヶー]*$";
    return katakanaInput.chars()
      .mapToObj(c -> (char) c)
      .anyMatch(c -> Pattern.matches(regex, String.valueOf(c)));
  }

  /**
   * check if zipcode is proper format
   * @param zipcode code to check
   * @return result
   */
  public static boolean isPostalCode(String zipcode) {
    String regex = "^(\\d{7})$";
    return zipcode.matches(regex);
  }

  /**
   * check if phoneNumber is proper format
   * @param phoneNumber phoneNumber to check
   * @return result
   */
  public static boolean isPhoneNumber(String phoneNumber) {
    String regex = "^(\\d{10,12})$";
    return phoneNumber.matches(regex);
  }
}
