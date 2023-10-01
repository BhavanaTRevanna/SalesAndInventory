package com.Inventory;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
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
import org.testng.annotations.Test;

import com.Sales.ObjectRepo.EditInventoryPage;
import com.Sales.ObjectRepo.HomePage;
import com.Sales.ObjectRepo.LoginPage;
import com.SalesAndInventory.genericUtils.BaseClass;
import com.SalesAndInventory.genericUtils.ExcelUtility;
import com.SalesAndInventory.genericUtils.FileUtility;
import com.SalesAndInventory.genericUtils.JavaUtility;
import com.SalesAndInventory.genericUtils.WebDriverUtility;

public class EditInventoryPOM extends BaseClass{

	@Test(groups = "Regression")
	public  void editInventoryPOM() throws Throwable {

		String sheetName="data";
		String productName = "Lenovo";
		String quan="45";
		String onhand="40";

		String custName=eLib.readDataFromExcelSheet(sheetName, 10, 1);

		
		HomePage hp=new HomePage(driver);
		EditInventoryPage ei=new EditInventoryPage(driver);
		
		hp.getInventoryBtn().click();
		ei.selectPro(productName, driver);
		ei.editPro(driver, quan, onhand);

	}

}
