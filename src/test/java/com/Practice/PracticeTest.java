package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class PracticeTest {

	public static void main(String[] args) throws Throwable {
		
		// to update the data into database
		Driver driver= new Driver();
		Connection con=null;
		Statement state =null;
		DriverManager.registerDriver(driver);
		try {
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_data", "root", "root");
	
	 state = con.createStatement();
	
	String query = "insert into employee values('Sinchana','9886813802','Shivamogga','QA'),('Prashanth','4204208409','Mistake Island','Tester');";
	
	int result = state.executeUpdate(query);
	if (result==2) {
		System.out.println("Data is updated successfullyy....");
		
	}
	else {
		System.out.println("Failed to update Data ;(");
	}
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	
		
		
	// to read the data from database
	//	Connection con1;
		
		try {
			//Driver driver1=new Driver();
			
			//DriverManager.registerDriver(driver1);
			
			//con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_data", "root", "root");
			 
			// Statement state1 = con1.createStatement();
			 String query1 = "select * from employee";
			 
			 ResultSet result1 = state.executeQuery(query1);
			 
			 while (result1.next()) {
				 System.out.println(result1.getString(1)+" "+result1.getString(2)+" "+result1.getString(3)+" "+result1.getString(4));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
		}
		
		
		
		

	}

}
