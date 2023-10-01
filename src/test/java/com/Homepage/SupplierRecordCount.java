package com.Homepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import com.SalesAndInventory.genericUtils.ExcelUtility;
import com.SalesAndInventory.genericUtils.FileUtility;
import com.SalesAndInventory.genericUtils.JavaUtility;
import com.SalesAndInventory.genericUtils.WebDriverUtility;

public class SupplierRecordCount {
	public static void main(String[] args) throws Throwable {
		
		//to read data from property file
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		//to read data from excel file

    
		WebDriver driver=null;
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD =fLib.getPropertyKeyValue("password");
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else 
			System.out.println("Invalid Input");

		driver.get(URL);
		wLib.maximizeTheBrowser(driver);
		wLib.implicitlyWait(driver, 10);
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();

		wLib.acceptAlertPopUp(driver);
		String record = driver.findElement(By.xpath("//div[contains(.,'Supplier')]/div[@class='h6 mb-0 font-weight-bold text-gray-800']")).getText();
		System.out.println(record);

		
		driver.findElement(By.xpath("//span[contains(.,'Supplier')]")).click();
		driver.findElement(By.xpath("//h4//i")).click();
		
		eLib.getMultipleDataFromExcelByName("supplierCount", 0, 1, driver);
		//driver.findElement(By.name("companyname")).sendKeys(comName);
		WebElement province = driver.findElement(By.id("province"));
		wLib.selectDropDown("Bohol", province);

		//driver.findElement(By.name("phonenumber")).sendKeys("6568475");


		driver.findElement(By.xpath("//form[@action='sup_transac.php?action=add']/descendant::button[@class='btn btn-success']")).click();

		driver.findElement(By.xpath("//span[contains(.,'Home')]")).click();

		String erecord = driver.findElement(By.xpath("//div[contains(.,'Supplier')]/div[@class='h6 mb-0 font-weight-bold text-gray-800']")).getText();
		System.out.println(erecord);

		if (record.equals(erecord)) {
			System.out.println("supplier count is not changing");
		}
		else
			System.out.println("supplier count is changing");

		driver.findElement(By.id("userDropdown")).click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(.,'Logout') and@class='dropdown-item']"));
		wLib.mouseHoverOnElement(driver, logout);
		logout.click();
		driver.findElement(By.xpath("//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")).click();

		driver.close();

	}

}
