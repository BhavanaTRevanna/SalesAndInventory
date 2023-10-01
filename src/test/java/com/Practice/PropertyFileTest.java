package com.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyFileTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Properties pObj= new Properties();
		pObj.setProperty("browser", "chrome");
		pObj.setProperty("url", "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		pObj.setProperty("username", "unguardable");
		pObj.setProperty("password", "admin");
		
		FileOutputStream fout=new FileOutputStream("src\\test\\resources\\CommonData.properties");
		pObj.store(fout, "write data");
		fout.close();	
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		System.out.println("browser--->"+BROWSER);
		System.out.println("url-->"+URL);
		System.out.println("Username-->"+USERNAME);
		System.out.println("Password-->"+PASSWORD);
		
		

	}

}
