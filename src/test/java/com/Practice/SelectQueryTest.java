package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {

	public static void main(String[] args)  throws Throwable{
       Driver driver = new Driver();
       Connection con=null;
       try {
		
      DriverManager.registerDriver(driver);
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_data", "root", "root");
      
     
     Statement state = con.createStatement();
     String query = "select * from project;";
     
     ResultSet result = state.executeQuery(query);
     
     while(result.next()) {
    	 System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
     }
	} catch (Exception e) {
	}
       finally {
		con.close();
	}
	}

}
