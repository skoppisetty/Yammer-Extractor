import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ReverseLines {

  public static void main(String[] args) {
    try {
      BufferedReader input = new BufferedReader(new FileReader("out0.txt"));
      ArrayList<String> list = new ArrayList<String>();
      String line;
      while ((line = input.readLine()) != null) {
        list.add(line);
      }
      input.close();

      Collections.reverse(list);

      PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("1.txt")));
      for (Iterator<String> i = list.iterator(); i.hasNext();) {
        output.println((String) i.next());
      }
      output.close();
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}