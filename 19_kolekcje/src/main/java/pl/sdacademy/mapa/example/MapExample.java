package pl.sdacademy.mapa.example;
import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;

public class MapExample {
  public static void main(String[] args) {
    countWordsExample();
  }

  public static void countWordsExample(){

    String anyString ="Gatunki Capsicum zostały odnalezione w Peru w grobach w Ancon i Huata Prieta, co świadczyło o uprawie tych gatunków na długo przed odkryciem Ameryki. Dla Hiszpanów i Portugalczyków, którzy poszukiwali pieprzu, odkrycie papryki – nowego, znacznie ostrzejszego „pieprzu indiańskiego\" – stało się bardzo zyskowne. Po zdobyciu Meksyku przez Hernána Cortésa uprawa papryki dość szybko rozprzestrzeniła się na inne kraje tropikalne. Ponieważ nasiona papryki długo zachowują zdolność kiełkowania, można je było dość łatwo przewozić na większe odległości.";
    List<String> listOfWords = Arrays.asList(anyString.split("\\s"));
    Map<String,Integer> words = new HashMap<>();

    for (String anyWord:listOfWords) {
      if(words.containsKey(anyWord)==false){
        words.put(anyWord,1);
      }
      else{
        words.put(anyWord,words.get(anyWord)+1);
      }
    }

    System.out.println(words);
  }

  public static void peppersExample(){
    Map<String,Integer> peppers = new HashMap<>();

    peppers.put("Habanero",100_000);
    peppers.put("Jalapeno",2_500);
    peppers.put("PepperX",3_180_000);
    peppers.put("Pepperoni",100);

    System.out.println(peppers);
    System.out.println(peppers.get("PepperX"));
    System.out.println(peppers.entrySet());
    for (Map.Entry<String,Integer> entry: peppers.entrySet()){
      if(entry.getValue()==2_500){
        System.out.println(entry.getKey());
      }
    }
  }


}
