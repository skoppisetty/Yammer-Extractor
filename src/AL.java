import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
class AL extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
    JTextField t1,t2;
    String text1,text2;
	Font f;
	JButton b1,b2;
	Container c;
	AL( )
	{
	   c=getContentPane();
		c.setLayout(null);
		l1=new JLabel("Enter time");
		l1.setBounds(500,300,80,20);
		l2=new JLabel("Enter Group Id");
	    l2.setBounds(500,350,90,20);
		l3=new JLabel("Get JSON messages");
		l3.setFont(new Font("Curlz MT",Font.BOLD,40));
		l3.setBounds(550,50,500,50);
		t1=new JTextField(20);
		t1.setText("");
		t1.setBounds(600,300,250,20);
        t2= new JTextField(20);
		t2.setText("");
		t2.setBounds(600,350,250,20);
	    b1=new JButton("OK");
		b1.setBounds(600,400,80,20);
	    b2 = new JButton("Exit");
		b2.setBounds(775,400,80,20);
		  
		b1.addActionListener(this);
		
		b2.addActionListener(this);
		c.add(l3);
		c.add(l1);c.add(t1);
		c.add(l2);c.add(t2);
	    c.add(b1);
        c.add(b2);
	     setVisible(true);
       setSize(1720,860);
	  
	}
	public void actionPerformed(ActionEvent a)
	{
		String str=a.getActionCommand();
		
      if(str.equalsIgnoreCase("OK"))
		{
    	  long l;
    	  boolean b=false;
    	  text1=t1.getText();
 		  text2=t2.getText();
 		 l = Long.parseLong(text2);
 		 GsonExample ge=new GsonExample();
 		 long day,month,year;
 		 
 		 try
 		 {
 		 ge.Json_msg(text1,l);
 		 JOptionPane.showMessageDialog(null,"Messages Created");
 		
 		 }
 		 catch(Exception e)
 		 {
 			e.printStackTrace();
 		 }
 	
 		 dispose();

 		 //code for generating json msgs should be put here
		//  dispose();
		}
		else if(str.equalsIgnoreCase("Exit"))
		{
			 text1=t1.getText();
	 		 text2=t2.getText();
	 		 System.out.println("text is "+text1+"  "+text2);
			JOptionPane.showMessageDialog(null,"Thank You");
		dispose();
			}  	
	
	}
public static void main(String args[]) 
	{

       AL ob1=new AL();
      
	  
	}
		
}

