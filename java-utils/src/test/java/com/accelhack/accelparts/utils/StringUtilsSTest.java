package com.accelhack.accelparts.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsSTest {

  @ParameterizedTest
  @CsvSource({
    /* 英字（スペース）   */ "TanakaTaro, Tanaka Taro  ",
    /* 英字（スペースなし）*/ "TanakaTaro,TanakaTaro",
    /* かな（スペース）   */ "田中太郎, 田中太郎",
    /* かな（スペースなし）*/ "田中太郎, 田  中　 太　　　郎",
  })
  void removeWhitespace(String expected, String hiraganaStr) {
    assertEquals(expected, StringUtils.removeWhitespace(hiraganaStr));
  }
}
