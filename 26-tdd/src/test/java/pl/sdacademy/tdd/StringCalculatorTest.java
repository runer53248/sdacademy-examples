package pl.sdacademy.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
  @DisplayName("simple examples")
  @ParameterizedTest(name = "input: \"{0}\" , output: {1}")
  @CsvSource({
          "'',0",
          "'1',1",
          "'1,2',3",
          "'1,2,3,4,5', 15",
          "'1\n2,3',6",
          "'1000,1001,2',1002"
  })
  void test1(String source, int expected) throws Exception {
    //when
    int result = StringCalculator.Add(source);
    //then
    assertThat(result).isEqualTo(expected);
  }

  @DisplayName("input: \"//;\\n1;2\" , output: 3")
  @Test
  void test2() throws Exception {
    //get
    String source = "//;\n1;2";

    //when
    int result = StringCalculator.Add(source);
    //then
    assertThat(result).isEqualTo(3);
  }

  @DisplayName("input: \"-1\" , output: java.lang.Exception: negatives not allowed [-1]")
  @Test
  void test3() throws Exception {
    //get
    String source = "-1";

    //when
    try {
      int result = StringCalculator.Add(source);
    } catch (Exception exception) {
      assertThat(exception.toString()).isEqualTo("java.lang.Exception: negatives not allowed [-1]");
    }
  }

  @DisplayName("input: \"0,-1,5,-13\" , output: java.lang.Exception: negatives not allowed [-1, -13]")
  @Test
  void test4() throws Exception {
    //get
    String source = "0,-1,5,-13";

    //when
    Throwable ex = catchThrowableOfType(() -> StringCalculator.Add(source), Exception.class);

    // then
    assertThat(ex).hasMessage("negatives not allowed [-1, -13]");
  }

  @DisplayName("input: \"//[***]\\n1***2***3\" , output: 6")
  @Test
  void test5() throws Exception {
    //get
    String source = "//[***]\n1***2***3";

    //when
    int result = StringCalculator.Add(source);

    //when
    assertThat(result).isEqualTo(6);
  }

  @DisplayName("input: \"//[*][%]\\n1*2%3\" , output: 6")
  @Test
  void test7() throws Exception {
    //get
    String source = "//[*][%]\n1*2%3";

    //when
    int result = StringCalculator.Add(source);

    //when
    assertThat(result).isEqualTo(6);
  }

  @DisplayName("input: \"//[abc][DEFF]\\n1abc2DEFF23abc1\" , output: 27")
  @Test
  void test8() throws Exception {
    //get
    String source = "//[abc][DEFF]\n1abc2DEFF23abc1";

    //when
    int result = StringCalculator.Add(source);

    //when
    assertThat(result).isEqualTo(27);
  }
}
