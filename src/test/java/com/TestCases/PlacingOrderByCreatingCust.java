package com.TestCases;

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

public class PlacingOrderByCreatingCust {
	public static void main(String[] args) throws Throwable {
		Random ran = new Random();
		int random = ran.nextInt();

		//to read data from property file
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);

		//to read data from excel file

		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("SalesAndInventory");
		int lastRow = sh.getLastRowNum();

		WebDriver driver=null;
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
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

		Alert a=driver.switchTo().alert();
		a.accept();

		driver.findElement(By.xpath("//span[contains(.,'POS')]")).click();
		driver.findElement(By.xpath("//a[@data-target='#keyboard']")).click();
		driver.findElement(By.xpath("//h6[contains(.,'Newmen E120')]/../input[@name='addpos']")).click();

		String custName = "Sinchana"+random;
		driver.findElement(By.xpath("//a[@class='btn btn-primary bg-gradient-primary']")).click();
		driver.findElement(By.xpath("//form[@action='cust_pos_trans.php?action=add']//input[@name='firstname']")).sendKeys("SAP");
		driver.findElement(By.xpath("//form[@action='cust_pos_trans.php?action=add']//input[@name='lastname']")).sendKeys(custName);
		driver.findElement(By.xpath("//form[@action='cust_pos_trans.php?action=add']//input[@name='phonenumber']")).sendKeys("5895414646");
		driver.findElement(By.xpath("//form[@action='cust_pos_trans.php?action=add']//button[@class='btn btn-success']")).click();

		WebElement cusName = driver.findElement(By.name("customer"));
		Select s=new Select(cusName);
		s.selectByVisibleText("SAP "+custName);

		driver.findElement(By.xpath("//button[contains(.,'SUBMIT')]")).click();
		driver.findElement(By.id("txtNumber")).sendKeys("250");
		driver.findElement(By.xpath("//button[contains(.,'PROCEED TO PAYMENT')]")).click();
		System.out.println("PlacingOrderByCreatingCustomer is successfull");


		a.accept();

		driver.findElement(By.id("userDropdown")).click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(.,'Logout') and@class='dropdown-item']"));
		Actions a2=new Actions(driver);
		a2.moveToElement(logout).click().perform();
		driver.findElement(By.xpath("//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")).click();
		driver.close();
	}
}
