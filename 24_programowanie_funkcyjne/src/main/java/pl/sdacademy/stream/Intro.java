package pl.sdacademy.stream;

import pl.sdacademy.user.User;

import java.util.Arrays;
import java.util.List;

public class Intro {
  public static void main(String[] args) {
    List<User> users=Arrays.asList(new User("imię","nazwisko",48),new User("imię","nazwisko",48),new User("imię","nazwisko",48),
            new User("imię","nazwisko",48));
    users.stream().map(User::getImie).map(String::toUpperCase).forEach(System.out::println);
  }
}
