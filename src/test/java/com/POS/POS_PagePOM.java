package com.POS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Sales.ObjectRepo.HomePage;
import com.Sales.ObjectRepo.LoginPage;
import com.Sales.ObjectRepo.POSPage;
import com.SalesAndInventory.genericUtils.BaseClass;
import com.SalesAndInventory.genericUtils.ExcelUtility;
import com.SalesAndInventory.genericUtils.FileUtility;
import com.SalesAndInventory.genericUtils.JavaUtility;
import com.SalesAndInventory.genericUtils.WebDriverUtility;

public class POS_PagePOM extends BaseClass{
	@Test(groups = "Regression")
	public  void pOS_PagePOM() throws Throwable {
		
	
		String sheetName="data";
		String custName=eLib.readDataFromExcelSheet(sheetName, 10, 1);		
		POSPage pos=new POSPage(driver);	
		pos.orderProduct(custName, 2500, driver);
	Assert.fail();
	}
}
