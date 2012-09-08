import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;

public class GsonExample {
    public void Json_msg(String date, long id1) throws IOException, InterruptedException, ParseException {

                                                Gson gson = new Gson();
                                                int k = 0;
                                                int j=0,last_j;
                                                long gid=id1;
                                                String userdate=date;
                                                String strLine="";
                                                String outLine="";
                                                File f1 = new File("sortedfinal.txt");
                                                System.out.println(f1.delete());
                                                for(int i=1; i<200; i++) {
                try {

                                BufferedReader br = new BufferedReader(
                                                new FileReader("Data\\"+createJson(k,gid)));

                                //convert the json string back to object
                                Book obj = gson.fromJson(br, Book.class);
                                FileWriter fstream1 = new FileWriter("Data\\out"+ k +".txt");
                                  BufferedWriter out1 = new BufferedWriter(fstream1);
                                  //out1.write("id,created_at,replied_to_id,body\n");
                                  String Mstrng =(String.valueOf(obj.messages).substring(2,String.valueOf(obj.messages).length()-1)).replace(", "+"\n","\n");
                                  Mstrng =Mstrng.replace("]"+"\n","\n");
                                out1.write(Mstrng);
                                out1.close();
                
                } catch (IOException e) {
                                e.printStackTrace();
                }

                 BufferedReader reader = new BufferedReader(new FileReader("Data\\out" + k +".txt"));
     Map<String, List<String>> map = new TreeMap<String, List<String>>();
String line = reader.readLine();//read header
while ((line = reader.readLine()) != null) {
         String key = getField(line);
         List<String> l = map.get(key);
         if (l == null) {
                 l = new LinkedList<String>();
                 map.put(key, l);
         }
         l.add(line);

}
reader.close();
FileWriter writer = new FileWriter("Data\\sorted_numbersfinal"+k+".txt");
//writer.write("UserID, Module, Mark\n");
  for (List<String> list : map.values()) {
         for (String val : list) {
                writer.write(val);
                 writer.write("\n");
         }
}
writer.close();
BufferedReader input = new BufferedReader(new FileReader("Data\\sorted_numbersfinal"+k+".txt"));
ArrayList<String> list = new ArrayList<String>();
String lines;
while ((lines = input.readLine()) != null) {
   list.add(lines);
}
input.close();

Collections.reverse(list);

PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("sortedfinal.txt",true)));
for (Iterator<String> m = list.iterator(); m.hasNext();) {
   output.println((String) m.next());
}
output.close();
String k1= readLastLine("sortedfinal.txt");
//System.out.print(k1);
k= Integer.parseInt(k1.substring(0,9));
System.out.println(k);
String temp = k1;
k1= k1.substring(10,20);
System.out.println(k1);
last_j=j;
j++;
System.out.println("j is "+j);
//String compdate = "2012/07/28";
DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
Date d = (Date)formatter.parse(k1);
Date d1 = (Date)formatter.parse(userdate);
System.out.println(d);
if (i%10==0)
{ Thread.sleep(30000);}
                                                 
 if (d.compareTo(d1)<0)
{ 
	  System.out.println("last_j is "+last_j); 
	  int previous = last_j*19+1; 
	  FileInputStream fstream = new FileInputStream("sortedfinal.txt");
	  DataInputStream in = new DataInputStream(fstream);
	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  FileWriter fw = new FileWriter("Filter.txt");
	  BufferedWriter bw1 = new BufferedWriter(fw);       
	 for(i=0;i<previous;i++)
	 {
	   strLine=br.readLine();
	   outLine=outLine+strLine+"\n";
	 }	
	 System.out.println("outline is"+outLine);
	  while((strLine=br.readLine())!=null)
	  {
		 String da= strLine.substring(10,20);
		 Date d3 = (Date)formatter.parse(da);
		 if (d3.compareTo(d1)<0)
		 {
			  bw1.write(outLine);
			  in.close();
			  bw1.close(); 
			  return;
		 }
		 else
			 outLine=outLine+strLine+"\n";
			   
	  }
	  
	  System.out.println("last is "+temp);
	  String lastdate= k1.substring(10,20);
	  System.out.println("last is "+lastdate);
	 
	 
	 return;
                //Thread.sleep(30000);
                }
                                                }
}

private static String getField(String line) {
return line.split(",")[0];// extract value you want to sort on
}
   
public static String readLastLine( String fileName ) {
    try {
        java.io.File file = new java.io.File( fileName );
        java.io.RandomAccessFile fileHandler = new java.io.RandomAccessFile( file, "rw" );
        long fileLength = file.length() - 1;
        StringBuilder sb = new StringBuilder();

        for( long filePointer = fileLength; filePointer != -1; filePointer-- ) {
            fileHandler.seek( filePointer );
            int readByte = fileHandler.readByte();                
 
            if( readByte == 0xA ) {
                if( filePointer == fileLength ) {
                    continue;
                } else {
                    break;
                }
            } else if( readByte == 0xD ) {
                if( filePointer == fileLength - 1 ) {
                    continue;
                } else {
                    break;
                }                    
            }

            sb.append( ( char ) readByte );
        }

        String lastLine = sb.reverse().toString();
        return lastLine.substring(0, Math.min(lastLine.length(), 20));
    } catch( java.io.FileNotFoundException e ) {
        e.printStackTrace();
        return null;
    } catch( java.io.IOException e ) {
        e.printStackTrace();
        return null;
    }
}
public static String createJson(int id, long gid) throws IOException {
String yammerurl;
if (id == 0) {
            yammerurl = "https://www.yammer.com/api/v1/messages/in_group/"+gid+".json?email=skoppisetty@youremail.com&access_token=Ab4k0f9yK77bhgfghgfh";
        } 
else yammerurl = "https://www.yammer.com/api/v1/messages/in_group/"+gid+".json?email=skoppisetty@youremail.com&access_token=Ab4k0f9yK77bhgfghgfh&older_than=" + id ;               
  URL oracle = new URL(yammerurl);
                        URLConnection yc = oracle.openConnection();
                               
                        BufferedReader in = new BufferedReader(new InputStreamReader(
                                                    yc.getInputStream()));
                        String inputLine;
                        FileWriter fstream = new FileWriter("Data\\output"+ id +".json");
                        BufferedWriter out = new BufferedWriter(fstream);
                            
                        while ((inputLine = in.readLine()) != null) 
                                   out.write(inputLine + "\n");
                      
                       in.close();
                        out.close();
                                                                return "output" + id + ".json";
}
}
