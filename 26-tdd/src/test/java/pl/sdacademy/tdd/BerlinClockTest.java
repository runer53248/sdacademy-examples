package pl.sdacademy.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockTest {

  @DisplayName("check seconds")
  @ParameterizedTest(name = "{0}, result: {1}")
  @CsvSource({
          //format hh:mm:ss
          "'10:15:30',s",
          "'10:15:31',''",
          "'10:15:32',s",
          "'10:15:33',''"
  })
  void test_seconds(String source, String expected) throws Exception{
    //given
    LocalTime time = LocalTime.parse(source);

    //when
    String result = BerlinClock.Calculate(time);

    //then
    assertThat(result).contains(expected);

  }

  @DisplayName("check single minutes")
  @ParameterizedTest(name = "{0}, result: {1}")
  @CsvSource({
          //format hh:mm:ss
          "'10:00:30',''",
          "'10:59:31','mmmm'",
          "'10:32:32','mm'",
          "'10:34:33','mmmm'",
          "'10:35:33',''"
  })
  void testSingleMinutes(String source, String expected) throws Exception{
    //given
    LocalTime time = LocalTime.parse(source);

    //when
    String result = BerlinClock.Calculate(time);

    //then
    assertThat(result.contains(expected)).isEqualTo(true);
  }

  @DisplayName("check five minutes")
  @ParameterizedTest(name = "{0}, result: {1}")
  @CsvSource({
          //format hh:mm:ss
          "'10:00:30',''",
          "'10:59:31','MMWMMWMMWMM'",
          "'10:32:32',''",
          "'10:34:33','MMWM'",
          "'10:35:33','MMWMMWM'"
  })
  void testFiveMinutes(String source, String expected) throws Exception{
    //given
    LocalTime time = LocalTime.parse(source);

    //when
    String result = BerlinClock.Calculate(time);

    //then
    assertThat(result.contains(expected)).isEqualTo(true);
  }

  @DisplayName("check single hour")
  @ParameterizedTest(name = "{0}, result: {1}")
  @CsvSource({
          //format hh:mm:ss
          "'00:00:30',''",
          "'23:59:31','hhh'",
          "'02:32:32','hh'",
          "'08:34:33','hhh'",
          "'14:35:33','hhhh'"
  })
  void testSingleHour(String source, String expected) throws Exception{
    //given
    LocalTime time = LocalTime.parse(source);

    //when
    String result = BerlinClock.Calculate(time);

    //then
    assertThat(result.contains(expected)).isEqualTo(true);
  }

  @DisplayName("check five hour")
  @ParameterizedTest(name = "{0}, result: {1}")
  @CsvSource({
          //format hh:mm:ss
          "'00:00:30',''",
          "'23:59:31','HHHH'",
          "'02:32:32',''",
          "'08:34:33','H'",
          "'16:35:33','HHH'"
  })
  void testFiveHour(String source, String expected) throws Exception{
    //given
    LocalTime time = LocalTime.parse(source);

    //when
    String result = BerlinClock.Calculate(time);

    //then
    assertThat(result.contains(expected)).isEqualTo(true);
  }

  @DisplayName("check convert to time")
  @ParameterizedTest(name = "{0}, result: {1}")
  @CsvSource({
          //format hh:mm:ss
          "'00:00:00', 'YOOOOOOOOOOOOOOOOOOOOOOO'",
          "'23:59:59', 'ORRRRRRROYYRYYRYYRYYYYYY'",
          "'16:50:06', 'YRRROROOOYYRYYRYYRYOOOOO'",
          "'11:37:01', 'ORROOROOOYYRYYRYOOOOYYOO'"
  })
  void testConvert(String source, String expected) throws Exception{
    //given
    LocalTime time = LocalTime.parse(source);

    //when
    String result = BerlinClock.convertToBerlin(BerlinClock.Calculate(time));

    //then
    assertThat(result).isEqualTo(expected);
  }

  @DisplayName("check convert to time")
  @ParameterizedTest(name = "{0}, result: {1}")
  @CsvSource({
          //format hh:mm:ss
          //"'YOOOOOOOOOOOOOOOOOOOOOOO', '00:00'",
          "'ORRRRRRROYYRYYRYYRYYYYYY', '23:59'",
          "'YRRROROOOYYRYYRYYRYOOOOO', '16:50'",
          "'ORROOROOOYYRYYRYOOOOYYOO', '11:37'"
  })
  void testConvertToDigital(String source, String expected) throws Exception{
    //given
    String given=source;

    //when
    String result = BerlinClock.convertBerlinToDigital(given);

    //then
    assertThat(result).isEqualTo(expected);
  }
}
