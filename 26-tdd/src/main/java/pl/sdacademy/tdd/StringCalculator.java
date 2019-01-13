package pl.sdacademy.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

  static int Add(String numbers) throws Exception {

    if(numbers.isEmpty())return 0;

    String regex="[\\n]";//only new line  is separator for delimeters part
    String delimeterPart = numbers.split(regex)[0];

    if(delimeterPart.startsWith("//")){

      delimeterPart = numbers.substring(numbers.indexOf("//")+2, numbers.indexOf("\n"));

      if(delimeterPart.contains("[")){//possibly multiple delimeters

        delimeterPart=delimeterPart.replace("]","");
        String[] delimeters = delimeterPart.split("\\[");

        for (String delimeter: delimeters ) {
          if(delimeter.isEmpty())continue;
          numbers=numbers.replace(delimeter,",");
        }
      }
      else{//single delimeter
        numbers=numbers.replace(delimeterPart,",");
      }
    }

    regex="[\\n,]";//new line or comas separator
    String[] parts = numbers.split(regex);

    int result=0;
    List<Integer> exceptionMsg=new ArrayList();
    boolean haveNegatives=false;

    for (String part: parts) {
      if(part.matches("-?\\d+")){
        int value=Integer.parseInt(part);
        if(value<0){
          haveNegatives=true;
          exceptionMsg.add(value);
        }

        if(value<=1000){
          result+=value;
        }

      }
    }

    if(haveNegatives){
      throw new Exception("negatives not allowed "+exceptionMsg.toString());
    }

    return result;
  }
}
