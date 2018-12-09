package pl.sdacademy.io;

import java.io.*;
import java.lang.annotation.Target;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

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
    OutputStream outputStream ;
    Files.copy(Paths.get("path1","file.txt"),Paths.get("path2","file.txt"));

    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(Paths.get("files","file.txt").toFile()))){

      String input=bufferedReader.readLine();
      while(input!=null){
        System.out.println(input);
        input=bufferedReader.readLine();
      }
    }

    URLConnection urlConnection = new URL("http://google.pl").openConnection();
    urlConnection.getInputStream();


    try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(Paths.get("files","file.txt").toFile()))){
      bufferedWriter.write("String tekstowy.");
      bufferedWriter.newLine();
      bufferedWriter.write("2 String tekstowy.");
      bufferedWriter.newLine();
      bufferedWriter.flush();
    }

    List<String> listOfFilesInDir = Files.list(Paths.get("files")).map(Path::getFileName).map(Path::toString).collect(Collectors.toList());


  }

  static InputStream inputStream() throws IOException {
    if(true){
      return fileSource();
    }
    else if(false){
      return new URL("http://google.pl").openConnection().getInputStream();
    }
    else{
      return new ByteArrayInputStream("hello".getBytes());
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
