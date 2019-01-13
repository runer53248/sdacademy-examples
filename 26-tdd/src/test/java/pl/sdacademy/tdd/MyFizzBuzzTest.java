package pl.sdacademy.tdd;

//import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

public class MyFizzBuzzTest {

  @DisplayName("Given {0} then return {1} acording to the examples")
  @ParameterizedTest(name = "Given {0} return {1}")
  @CsvSource({
          "1, 1",
          "2, 2",
          "3, Fizz",
          "6, Fizz",
          "5, Buzz",
          "10, Buzz",
          "15, FizzBuzz",

  })
  void test(int number,String expected)throws Exception{
    //when
    String msg = MyFizzBuzz.msg(number);
    //then
    assertThat(msg).isEqualTo(expected);
  }

  /*@DisplayName("given 1 when call myfizzbuzz, then the result should be non-empty string")
  @Test
  void testx() throws Exception{
    //given
    int number =1;

    //when
    String msg = MyFizzBuzz.msg(number);

    //then
    Assertions.assertThat(msg).isNotEmpty();
    //fail("Write your test");
  }

  @DisplayName("given 1 when call myfizzbuzz, then the result should be '1' ")
  @Test
  void test0() throws Exception{
    //given
    int number =1;

    //when
    String msg = MyFizzBuzz.msg(number);

    //then
    Assertions.assertThat(msg).isEqualTo("1");
    //fail("Write your test");
  }

  @DisplayName("given 2 when call myfizzbuzz, then the result should be '2' ")
  @Test
  void test1() throws Exception{
    //given
    int number =2;

    //when
    String msg = MyFizzBuzz.msg(number);

    //then
    Assertions.assertThat(msg).isEqualTo("2");
    //fail("Write your test");
  }

  @DisplayName("given 3 when call myfizzbuzz, then the result should be 'Fizz' ")
  @Test
  void test2() throws Exception{
    //given
    int number =3;

    //when
    String msg = MyFizzBuzz.msg(number);

    //then
    Assertions.assertThat(msg).isEqualTo("Fizz");
  }

  @DisplayName("given 5 when call myfizzbuzz, then the result should be 'Buzz' ")
  @Test
  void test3() throws Exception{
    //given
    int number =5;

    //when
    String msg = MyFizzBuzz.msg(number);

    //then
    Assertions.assertThat(msg).isEqualTo("Buzz");
  }

  @DisplayName("given 6 when call myfizzbuzz, then the result should be 'Fizz' ")
  @Test
  void test4() throws Exception{
    //given
    int number =6;

    //when
    String msg = MyFizzBuzz.msg(number);

    //then
    Assertions.assertThat(msg).isEqualTo("Fizz");
  }

  @DisplayName("given 10 when call myfizzbuzz, then the result should be 'Buzz' ")
  @Test
  void test5() throws Exception{
    //given
    int number =10;

    //when
    String msg = MyFizzBuzz.msg(number);

    //then
    Assertions.assertThat(msg).isEqualTo("Buzz");
  }

  @DisplayName("given 15 when call myfizzbuzz, then the result should be 'FizzBuzz' ")
  @Test
  void test6() throws Exception{
    //given
    int number =15;

    //when
    String msg = MyFizzBuzz.msg(number);

    //then
    Assertions.assertThat(msg).isEqualTo("FizzBuzz");
  }

  @DisplayName("given 30 when call myfizzbuzz, then the result should be 'FizzBuzz' ")
  @Test
  void test7() throws Exception{
    //given
    int number =30;

    //when
    String msg = MyFizzBuzz.msg(number);

    //then
    Assertions.assertThat(msg).isEqualTo("FizzBuzz");
  }*/
}
