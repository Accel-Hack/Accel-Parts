package com.accelhack.accelparts.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JapanUtilsSTest {

  @ParameterizedTest
  @CsvSource({
    /* 全角カナ一覧 */ "true, ァアィイゥウェエォオカガキギクグケゲコゴサザシジスズセゼソゾタダチヂッツヅテデトドナニヌネノハバパヒビピフブプヘベペホボポマミムメモャヤュユョヨラリルレロヮワヰヱヲンヴヵヶ, ",
    /* 空文字　　　 */ "true, ''",
    /* 半角カナ一覧 */ "false, ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝｧｨｩｪｫｯｬｭｮｰｶﾞｷﾞｸﾞｹﾞｺﾞｻﾞｼﾞｽﾞｾﾞｿﾞﾀﾞﾁﾞﾂﾞﾃﾞﾄﾞﾊﾞﾋﾞﾌﾞﾍﾞﾎﾞﾊﾟﾋﾟﾌﾟﾍﾟﾎﾟｳﾞ, ",
    /* 全角かな　　 */ "false, あいうえお",
    /* 数字　　　　 */ "false, 20220912",
  })
  void isZenkakuKatakana(boolean expected, String katakanaStr) {
    assertEquals(expected, JapanUtils.isZenkakuKatakana(katakanaStr));
  }

  @ParameterizedTest
  @CsvSource({
    /* 正常系　　　 */ "true, 1638001",
    /* 数字以外　　 */ "false, あいうえお",
    /* 規定外の長さ */ "false, 20220912",
  })
  void isPostalCode(boolean expected, String postalCode) {
    assertEquals(expected, JapanUtils.isPostalCode(postalCode));
  }

  @ParameterizedTest
  @CsvSource({
    /* 正常系　　　 */ "true, 09012345678",
    /* 数字以外　　 */ "false, あいうえお",
    /* 規定外の長さ */ "false, 20220912",
  })
  void isPhoneNumber(boolean expected, String str) {
    assertEquals(expected, JapanUtils.isPhoneNumber(str));
  }
}
