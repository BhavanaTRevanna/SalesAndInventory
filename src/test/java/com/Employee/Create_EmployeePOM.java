package com.Employee;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Sales.ObjectRepo.CreateEmployeePage;
import com.Sales.ObjectRepo.HomePage;
import com.Sales.ObjectRepo.LoginPage;
import com.SalesAndInventory.genericUtils.BaseClass;
import com.SalesAndInventory.genericUtils.ExcelUtility;
import com.SalesAndInventory.genericUtils.FileUtility;
import com.SalesAndInventory.genericUtils.JavaUtility;
import com.SalesAndInventory.genericUtils.WebDriverUtility;

public class Create_EmployeePOM extends BaseClass{
	
	@Test
	public  void create_EmployeePOM() throws Throwable{

		String sheetName="data";
		String sheetNamepaths="createEmployee";
		String gender1=eLib.readDataFromExcelSheet(sheetName, 0, 1);
		String email1=eLib.readDataFromExcelSheet(sheetName, 1, 1);
		String jobs1=eLib.readDataFromExcelSheet(sheetName, 2, 1);
		String date1=eLib.readDataFromExcelSheet(sheetName, 3, 1);
		String month1=eLib.readDataFromExcelSheet(sheetName, 4, 1);
		String year1=eLib.readDataFromExcelSheet(sheetName, 5, 1);
		String province1=eLib.readDataFromExcelSheet(sheetName, 6, 1);


		
		CreateEmployeePage ce=new CreateEmployeePage(driver);
		  Assert.fail();

		HashMap<String, String> map = eLib.getDataFromExcel(sheetNamepaths, 0, 1, driver);

	    ce.createCustomer(map, driver, jLib, wLib, gender1, email1, jobs1, date1, month1, year1, province1);

	}

}
