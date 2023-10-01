package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args)  throws Throwable{
		 Driver driver = new Driver();
	       Connection con=null;
	       int result = 0;
	     
		try {
	      DriverManager.registerDriver(driver);
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_data", "root", "root");
	      
	     
	     Statement state = con.createStatement();
	     
	     String query = "insert into project values('API','Sanjay','Bangalore',1)";
	     
	     result = state.executeUpdate(query);
   	
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			
			if (result==1) {
				System.out.println("data is created");
				
			}
			else
				System.out.println("data is not created");
		}
	       
	}

}
