package pl.sdacademy.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IoExample {
  public static void main(String[] args) throws IOException {

    /*Path path= Paths.get("files", "sourcefile.txt");
    //InputStream inputStream= new FileInputStream(path.toFile());
    //Reader reader;
    BufferedWriter bufferedWriter;
    bufferedWriter.

    try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileSource()))){
      String line = bufferedReader.readLine();
      while(line!=null){
        System.out.println(line);
        line = bufferedReader.readLine();
      }
    }*/

    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(Paths.get("files","file.txt").toFile()))){

      String input=bufferedReader.readLine();
      while(input!=null){
        System.out.println(input);
        input=bufferedReader.readLine();
      }
    }


    try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(Paths.get("files","file.txt").toFile()))){
      bufferedWriter.write("String tekstowy.");
      bufferedWriter.newLine();
      bufferedWriter.write("2 String tekstowy.");
      bufferedWriter.newLine();
      bufferedWriter.flush();
    }

  }

  private static InputStream fileSource() throws FileNotFoundException {
    Path path = Paths.get("files", "sourcefile.txt");
    return new FileInputStream(path.toFile());
  }

  private static InputStream source() {
    return new ByteArrayInputStream("hello".getBytes());
  }
}
