import java.lang.*;
import java.io.*;

public class CompString{
  public static void main(String[] args) throws IOException{

  System.out.println(sum("Feb"));
  System.out.println(sum("Dec"));
  
  }



	  public static int sum (String data) {
	    int i = 0;
	    if (data.equals("Jan")) {
	        i = 1;
	    }
	    else 
	    	 {
	    	i = 12;
	    }
	    
	    return i;
	  }
}