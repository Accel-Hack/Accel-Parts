package com.accelhack.accelparts.utils;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtils {

  /**
   * random alpha numeric string
   * @param length length of generated string
   * @return result
   */
  public static String alphaNumeric(int length) {
    // ASCII範囲–英数字(0-9、a-z、A-Z) lIL1oO0はわかりにくいので除外
    final String chars = "ABCDEFGHJKMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789";

    SecureRandom random = new SecureRandom();

    return IntStream.range(0, length)
      .map(i -> random.nextInt(chars.length()))
      .mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex)))
      .collect(Collectors.joining());
  }
}
