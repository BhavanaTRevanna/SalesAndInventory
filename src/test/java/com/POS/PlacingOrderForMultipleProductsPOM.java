package com.POS;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class PlacingOrderForMultipleProductsPOM extends BaseClass{


   @Test(groups = "Regression")
   public void placingOrderForMultipleProductsPOM() throws Throwable, Throwable, Throwable {
		String sheetName="data";

		String custName=eLib.readDataFromExcelSheet(sheetName, 10, 1);

		POSPage pos=new POSPage(driver);
		TransactionPage tp=new TransactionPage(driver);
		
		pos.orderMultipleProduct(custName, 2500, driver);
		tp.checkTransaction(custName, driver);
		

	}
}
