package com.accelhack.accelparts.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomUtilsSTest {

  @ParameterizedTest
  @CsvSource({
    /* 長さ10 */ "10",
    /* 長さ20 */ "20",
  })
  void alphaNumeric(int length) {
    String generatedString = RandomUtils.alphaNumeric(length);
    assertEquals(length, generatedString.length());
    generatedString.chars().forEach(c ->
      assertTrue(Character.isLetterOrDigit(c)));
  }
}
