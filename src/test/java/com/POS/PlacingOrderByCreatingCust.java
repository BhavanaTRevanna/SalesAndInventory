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

import com.SalesAndInventory.genericUtils.ExcelUtility;
import com.SalesAndInventory.genericUtils.FileUtility;
import com.SalesAndInventory.genericUtils.JavaUtility;
import com.SalesAndInventory.genericUtils.WebDriverUtility;

public class PlacingOrderByCreatingCust  {
	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();

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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();

		wLib.acceptAlertPopUp(driver);
		

		driver.findElement(By.xpath("//span[contains(.,'POS')]")).click();
		driver.findElement(By.xpath("//a[@data-target='#keyboard']")).click();
		driver.findElement(By.xpath("//h6[contains(.,'Newmen E120')]/../input[@name='addpos']")).click();

		String custName = "Sinchana"+jLib.getRandomnumber();
		driver.findElement(By.xpath("//a[@class='btn btn-primary bg-gradient-primary']")).click();
		driver.findElement(By.xpath("//form[@action='cust_pos_trans.php?action=add']//input[@name='firstname']")).sendKeys("SAP");
		driver.findElement(By.xpath("//form[@action='cust_pos_trans.php?action=add']//input[@name='lastname']")).sendKeys(custName);
		driver.findElement(By.xpath("//form[@action='cust_pos_trans.php?action=add']//input[@name='phonenumber']")).sendKeys("5895414646");
		driver.findElement(By.xpath("//form[@action='cust_pos_trans.php?action=add']//button[@class='btn btn-success']")).click();


		WebElement cusName = driver.findElement(By.name("customer"));
		wLib.selectDropDown("SAP "+custName, cusName);
		

		driver.findElement(By.xpath("//button[contains(.,'SUBMIT')]")).click();
		driver.findElement(By.id("txtNumber")).sendKeys("250");
		driver.findElement(By.xpath("//button[contains(.,'PROCEED TO PAYMENT')]")).click();
		System.out.println("PlacingOrderByCreatingCustomer is successfull");


		wLib.acceptAlertPopUp(driver);

		driver.findElement(By.id("userDropdown")).click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(.,'Logout') and@class='dropdown-item']"));
		wLib.mouseHoverOnElement(driver, logout);
		logout.click();
		driver.findElement(By.xpath("//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")).click();
		driver.close();
	}
}
