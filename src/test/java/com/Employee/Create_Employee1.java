package com.Employee;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
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

public class Create_Employee1 {
	public static void main(String[] args) throws Throwable{

		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		//to read data from excel file

		//	FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//	Workbook wb = WorkbookFactory.create(fi);
		//	Sheet sh = wb.getSheet("Sheet5");
		//	int lastRow = sh.getLastRowNum();

		//to read data from property file
		WebDriver driver=null;
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL =fLib.getPropertyKeyValue("url"); 
		String USERNAME =fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
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
		//driver.manage().window().maximize();

		wLib.implicitlyWait(driver, 10);

		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();

		wLib.acceptAlertPopUp(driver);


		driver.findElement(By.xpath("//span[contains(.,'Employee')]")).click();
		driver.findElement(By.xpath("//h4//i")).click();

		eLib.getMultipleDataFromExcel("createEmployee", 0, 1, driver);

		WebElement gender = driver.findElement(By.xpath("//form[@action='emp_transac.php?action=add']/descendant::select[@name='gender']"));
		wLib.selectDropDown(gender, "Female");

		driver.findElement(By.name("email")).sendKeys("bhavanatr@gmail.com");


		WebElement job = driver.findElement(By.name("jobs"));
		wLib.selectDropDown(job, 1);

		WebElement date = driver.findElement(By.name("hireddate"));
		date.click();
		date.sendKeys("12");
		date.sendKeys("02");
		date.sendKeys("1999");

		WebElement province = driver.findElement(By.name("province"));
		wLib.selectDropDown("Aklan", province);


		driver.findElement(By.xpath("//form[@action='emp_transac.php?action=add']/descendant::button[@class='btn btn-success']")).click();

		driver.findElement(By.id("userDropdown")).click();
		System.out.println("Employee created succesfully...");
		WebElement logout = driver.findElement(By.xpath("//a[contains(.,'Logout') and@class='dropdown-item']"));
		wLib.mouseHoverOnElement(driver, logout);
		logout.click();

		driver.findElement(By.xpath("//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")).click();

		driver.close();

	}

}
