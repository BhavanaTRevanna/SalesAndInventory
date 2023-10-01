package com.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDataBaseTest {
	public static void main(String[] args) throws Throwable {
		Driver driver = new Driver();
		Connection con=null;
		int num = 0;
		boolean flag = false;

		try {
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_data", "root", "root");   
			Statement state = con.createStatement();


			/*String table = "create table TYSS(ID INT(10), Name VARCHAR(20));";  
   int result = state.executeUpdate(table);
   System.out.println("table created");*/

			// to fetch names from Database
			String eNames="select * from tyss;";
			ResultSet names = state.executeQuery(eNames);

			Scanner s=new Scanner(System.in);

			// to add ID and Name
			System.out.println("Enter the Name of Employee");
			String name=s.nextLine();
			String data=null;


			while (names.next()){
				String n = names.getString(2);
				num = names.getInt(1);
				if(name.equalsIgnoreCase(n)) {
					flag=true;
				}		
			}
			if (flag) {
				System.out.println(name+" is present in table..   Data entering failed... );");


			}
			else {
				data = "insert into tyss values("+ ++num+",'"+name+"');";
				int add = state.executeUpdate(data);
				System.out.println("Data is added succesfully... :)");

			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
