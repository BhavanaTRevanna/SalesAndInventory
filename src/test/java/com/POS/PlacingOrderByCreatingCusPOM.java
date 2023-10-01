package com.POS;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Sales.ObjectRepo.HomePage;
import com.Sales.ObjectRepo.LoginPage;
import com.Sales.ObjectRepo.POSPage;
import com.Sales.ObjectRepo.TransactionPage;
import com.SalesAndInventory.genericUtils.BaseClass;
import com.SalesAndInventory.genericUtils.ExcelUtility;
import com.SalesAndInventory.genericUtils.FileUtility;
import com.SalesAndInventory.genericUtils.JavaUtility;
import com.SalesAndInventory.genericUtils.WebDriverUtility;

public class PlacingOrderByCreatingCusPOM  extends BaseClass{
	
	@Test(groups = "Regression")
	public void placingOrderByCreatingCusPOM() throws Throwable {
		
		String firstName="Bhavana";
		String lastName="T R";
		String phoneNum="455";

		
		HomePage hp=new HomePage(driver);
		POSPage pos=new POSPage(driver);
		TransactionPage tp=new TransactionPage(driver);
			
		pos.orderPlacingByCreatingCustomer(firstName, lastName, phoneNum, 1500, driver);
		tp.checkTransaction(firstName+" "+lastName, driver);
	}
}
