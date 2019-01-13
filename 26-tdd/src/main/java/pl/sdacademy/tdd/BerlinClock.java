package pl.sdacademy.tdd;

import java.time.LocalTime;

public class BerlinClock {

  public static String second="";

  public static String Calculate(LocalTime time) {

    String result ="";

    int seconds=time.getSecond();
    int minutes=time.getMinute();
    int hours=time.getHour();

    if(seconds%2==0)result+="s";//sekundy
    else result+="O";

    for(int i=0;i<4;i++){//5-cio godziny
      if(i<hours/5)result+="H";
      else result+="O";
    }
    for(int i=0;i<4;i++){//godziny
      if(i<hours%5)result+="h";
      else result+="O";
    }
    for(int i=0;i<11;i++){//5-cio minuty
      if(i<minutes/5){
        if(i%3==2)result+="W";
        else result+="M";
      }
      else result+="O";
    }
    for(int i=0;i<4;i++){//minuty
      if(i<minutes%5)result+="m";
      else result+="O";
    }

    return result;
  }

  public static String convertToBerlin(String input)
  {
    String result =input.replace("s","Y");
    result =result.replace("m","Y");
    result =result.replace("M","Y");
    result =result.replace("W","R");
    result =result.replace("h","R");
    result =result.replace("H","R");
    return result;
  }

  public static String convertBerlinToDigital(String input)
  {
    String[] data=input.split("");

    //int seconds=0;
    int minutes=0;
    int hours=0;

    final int SEC_POS=0;
    final int HOUR_5_POS=1;
    final int HOUR_POS=5;
    final int MINUTES_5_POS=9;
    final int MINUTES_POS=20;
    final int END_POS=24;

    for(int i=HOUR_5_POS;i<HOUR_POS;i++){//5-cio godziny
      if(!data[i].equals("O"))hours+=5;
    }
    for(int i=HOUR_POS;i<MINUTES_5_POS;i++){//godziny
      if(!data[i].equals("O"))hours+=1;
    }
    for(int i=MINUTES_5_POS;i<MINUTES_POS;i++){//5-cio minuty
      if(!data[i].equals("O"))minutes+=5;
    }
    for(int i=MINUTES_POS;i<END_POS;i++){//minuty
      if(!data[i].equals("O"))minutes+=1;
    }

    return ""+String.format("%02d", hours)+":"+String.format("%02d", minutes);
  }
}
