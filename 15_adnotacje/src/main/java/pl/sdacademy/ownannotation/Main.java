package pl.sdacademy.ownannotation;

import java.lang.reflect.InvocationTargetException;

public class Main {
  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
    //to do
    TestClass test=new TestClass();
    BenchmarkProcessor benchmarkProcessor= new BenchmarkProcessor();
    benchmarkProcessor.benchmark(test);

  }
}
