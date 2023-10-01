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

import com.SalesAndInventory.genericUtils.ExcelUtility;
import com.SalesAndInventory.genericUtils.FileUtility;
import com.SalesAndInventory.genericUtils.JavaUtility;
import com.SalesAndInventory.genericUtils.WebDriverUtility;

public class EditInventory {

	public static void main(String[] args) throws Throwable {
		

		//to read data from property file
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

		String productName = "Lenovo";

		driver.findElement(By.xpath("//span[contains(.,'Inventory')]")).click();

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(productName);
	
		List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
		int count = 0;
		for (WebElement webElement : allNames) {
			String text = webElement.getText();
			if(text.equals(productName)) {

				driver.findElement(By.xpath("//a[contains(.,' View')]")).click();
				driver.findElement(By.xpath("//a[contains(.,' Edit')]")).click();

				break;

			}
		}
		driver.findElement(By.xpath("//input[@placeholder='Quantity']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys("22");
		driver.findElement(By.xpath("//input[@placeholder='On Hand']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='On Hand']")).sendKeys("21");
		driver.findElement(By.xpath("//button[contains(.,'Update')]")).click();
		System.out.println("Quantity and On hand details updated  successfully... :)");

		wLib.acceptAlertPopUp(driver);

		driver.findElement(By.id("userDropdown")).click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(.,'Logout') and@class='dropdown-item']"));
		wLib.mouseHoverOnElement(driver, logout);
		logout.click();
		driver.findElement(By.xpath("//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")).click();
		driver.close();

	}

}
