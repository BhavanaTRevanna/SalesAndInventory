package com.Product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
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

import com.Sales.ObjectRepo.CreateProductPage;
import com.Sales.ObjectRepo.HomePage;
import com.Sales.ObjectRepo.LoginPage;
import com.SalesAndInventory.genericUtils.BaseClass;
import com.SalesAndInventory.genericUtils.ExcelUtility;
import com.SalesAndInventory.genericUtils.FileUtility;
import com.SalesAndInventory.genericUtils.JavaUtility;
import com.SalesAndInventory.genericUtils.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class CreateProductPOM extends BaseClass
{
	@Test(groups = "Smoke")
	public  void createProductPOM() throws Throwable {
		
		String sheetNamedata="data";
		String sheetname="createpro";
		String category = eLib.readDataFromExcelSheet(sheetNamedata, 7, 1);
		String supplier=eLib.readDataFromExcelSheet(sheetNamedata, 8, 1);
		String description=eLib.readDataFromExcelSheet(sheetNamedata, 9, 1);
		String date1=eLib.readDataFromExcelSheet(sheetNamedata, 3, 1);
		String month1=eLib.readDataFromExcelSheet(sheetNamedata, 4, 1);
		String year1=eLib.readDataFromExcelSheet(sheetNamedata, 5, 1);

		
		CreateProductPage cp=new CreateProductPage(driver);
		
		HashMap<String, String> map = eLib.getDataFromExcel(sheetname, 0, 1, driver);
		cp.createProduct(map, driver, description, category, supplier, date1, month1, year1);
		System.out.println("Product added");

		
	}
	}
