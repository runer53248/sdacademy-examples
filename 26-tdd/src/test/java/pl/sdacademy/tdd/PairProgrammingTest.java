package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PairProgrammingTest {

  @DisplayName("")
  @Test
  void test10()throws Exception{
    //given
    int number =1;

    //when
    String msg = MyFizzBuzz.msg(number);

    //then
    assertThat(msg).isNotEmpty();
    //fail("Write your test");
  }

}
