import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
 
public class ReadLastLine{
 
 public static void main(String[] args) throws Exception {
 
  FileInputStream in = new FileInputStream("sorted_numbers.txt");
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
 
  String strLine = null, tmp;
 
  while ((tmp = br.readLine()) != null)
  {
     strLine = tmp;
  }
 
  String lastLine = strLine;
  
  System.out.println(lastLine.substring(0, Math.min(lastLine.length(), 9)));
  
  URL oracle = new URL("https://www.yammer.com/api/v1/messages/in_group/233583.json?email=skoppisetty@deloitte.com&access_token=Ab4k0f9yK77bGqjdmsDA&older_than" + lastLine.substring(0, Math.min(lastLine.length(), 9)));
  URLConnection yc = oracle.openConnection();
         
  BufferedReader input = new BufferedReader(new InputStreamReader(
                              yc.getInputStream()));
  String inputLine;
  FileWriter fstream = new FileWriter("C:\\Users\\skoppisetty\\workspace\\yammerdata\\output1.json");
  BufferedWriter out = new BufferedWriter(fstream);
      
  while ((inputLine = input.readLine()) != null) 
     	   out.write(inputLine + "\n");

 input.close();
  out.close();
  
  in.close();
 }
}