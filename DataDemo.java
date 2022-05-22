import java.sql.*;
import java.util.*;
public class DataDemo
{
	public static void main(String[] args) 
	{
		try {
			  
		    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   }
		catch(Exception e){e.printStackTrace();}
				
		try{
			Connection con = DriverManager.getConnection("jdbc:odbc:Library");
		  
			Statement stmt = con.createStatement();
		     			
		     	System.out.println("----WELCOME TO LIBRARY SYSTEM----");
		     	System.out.println("----------1.Student Login--------");
		     	System.out.println("----------2.Faculty Login--------");
		     	System.out.println("----------3.Librarian Login--------");
		     	System.out.println("Enter your choice");
		     	Scanner sc=new Scanner(System.in);
		     	int n=sc.nextInt();
		     	switch(n)
		     	{
		     		case 1: System.out.println("---Student---");
		     			System.out.println("Enter Library ID");
		     			int id=sc.nextInt();
		     			ResultSet rs = stmt.executeQuery("select * from Students where LIBID="+id);
				    	while(rs.next())
					{
				    		System.out.println("*****LOGIN SUCESSFULL*****");
					       	System.out.println("HT NO. :"+rs.getString("ID")+"\n"+"NAME: "+rs.getString("NAME")+"\n"+"BRANCH: "+rs.getString("Branch"));
					} 
				    	break;
		     		case 2:System.out.println("---Faculty---");
     					System.out.println("Enter Library ID");
     					int id1=sc.nextInt();
     					ResultSet r= stmt.executeQuery("select* from Faculty where LIBID="+id1);
		    			while(r.next())
					{
		    				System.out.println("*****LOGIN SUCESSFULL*****");
			       			System.out.println("NAME: "+r.getString("NAME")+"\n"+"Subject: "+r.getString("Designation"));
			       		} 
		    			break;
		    			default: System.out.println("Invalid Selection");
		    			System.exit(0);
		     		}
		     		System.out.println("-----Available books are-----\n");
		     		ResultSet s= stmt.executeQuery("select* from Books");
		     		while(s.next())
		     		{
		     			System.out.println(s.getString("ID")+"-"+s.getString("Name")+"-"+s.getString("Category")+"-"+s.getString("Subject")+"-"+s.getString("Number of Copies"));
		     		
		     		}
		     		int c=0;
		     		while(c<4)
		     		{
		     			c++;
		     			System.out.println("1.ISSUE\t2.RENEWAL\t3.RETURN");
		     			System.out.println("Enter your choice");
		     			int ch=sc.nextInt();
		     			switch(ch)
		     			{
		     			case 1:System.out.println("Enter book ID");
		     					int i=sc.nextInt();
		     					ResultSet rs=stmt.executeQuery("select* from Books where ID="+i);
		     					while(rs.next())
		     					{
		     						System.out.println(rs.getString("Name")+"\t"+rs.getString("Category")+"\t"+rs.getString("Subject"));
		     					}
		     					System.out.println("Book is Issued");
		     						break;
		     			case 2:System.out.println("Enter book ID");
     					int i1=sc.nextInt();
     					ResultSet rs1=stmt.executeQuery("select* from Books where ID="+i1);
     					while(rs1.next())
     					{
     						System.out.println(rs1.getString("Name")+"\t"+rs1.getString("Category")+"\t"+rs1.getString("Subject"));
     					}
     					System.out.println("Renewal process completed");
     					break;
		     			default: System.out.println("Select another option");
		     			}
		     		}
		     		System.out.println("All the Four chances are completed\n------Logout SucessFull-----\n---THANK YOU---");
				   } 
		     		catch (Exception se) 
				      {
		        		se.printStackTrace();		        				     
		        	  }
		       } 
		

	}


