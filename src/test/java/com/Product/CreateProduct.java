package com.Product;

import java.io.FileInputStream;
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

import com.SalesAndInventory.genericUtils.ExcelUtility;
import com.SalesAndInventory.genericUtils.FileUtility;
import com.SalesAndInventory.genericUtils.JavaUtility;
import com.SalesAndInventory.genericUtils.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class CreateProduct {
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

		driver.findElement(By.xpath("//span[contains(.,'Product')]")).click();
		driver.findElement(By.xpath("//h4//i")).click();

		String prodName = "CPU"+jLib.getRandomnumber();
		driver.findElement(By.name("prodcode")).sendKeys("123"+jLib.getRandomnumber());
		driver.findElement(By.name("name")).sendKeys(prodName);
		driver.findElement(By.xpath("//form[@action='pro_transac.php?action=add']//textarea")).sendKeys("CPU");

		driver.findElement(By.name("quantity")).sendKeys("4");
		driver.findElement(By.name("onhand")).sendKeys("4");
		driver.findElement(By.name("price")).sendKeys("2,00,000");

		WebElement category = driver.findElement(By.name("category"));
		wLib.selectDropDown("CPU", category);

		Thread.sleep(2000);
		WebElement supplier = driver.findElement(By.name("supplier"));
		wLib.selectDropDown(supplier, "62");

		WebElement date = driver.findElement(By.name("datestock"));
		date.click();
		date.sendKeys("02");
		date.sendKeys("12");
		date.sendKeys("1999");

		driver.findElement(By.xpath("//form[@action='pro_transac.php?action=add']/descendant::button[@class='btn btn-success']")).click();

		System.out.println("Product added successfully..");

		driver.findElement(By.id("userDropdown")).click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(.,'Logout') and@class='dropdown-item']"));
		wLib.mouseHoverOnElementAndClick(driver, logout);
		driver.findElement(By.xpath("//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")).click();
		driver.close();

	}}
