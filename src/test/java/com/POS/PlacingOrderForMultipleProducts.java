package com.POS;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
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

import com.SalesAndInventory.genericUtils.ExcelUtility;
import com.SalesAndInventory.genericUtils.FileUtility;
import com.SalesAndInventory.genericUtils.JavaUtility;
import com.SalesAndInventory.genericUtils.WebDriverUtility;

public class PlacingOrderForMultipleProducts {
	public static void main(String[] args) throws Throwable {
		
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
				

		//to read data from excel file

		WebDriver driver=null;
		String BROWSER =fLib.getPropertyKeyValue("browser");
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

		driver.findElement(By.xpath("//span[contains(.,'POS')]")).click();
		driver.findElement(By.xpath("//a[@href='#motherboard']")).click();
		
		
		driver.findElement(By.xpath("//h6[contains(.,'Intel 12th gen mother board')]/../input[@name='addpos']")).click();

		driver.findElement(By.xpath("//a[@href='#processor']")).click();
		driver.findElement(By.xpath("//h6[contains(.,'₱ 55445')]/../input[@name='addpos']")).click();

		String custName = "a z";
		WebElement selectcustomer = driver.findElement(By.name("customer"));
		wLib.selectDropDown(custName, selectcustomer);

		driver.findElement(By.xpath("//button[contains(.,'SUBMIT')]")).click();
		driver.findElement(By.id("txtNumber")).sendKeys("250");
		driver.findElement(By.xpath("//button[contains(.,'PROCEED TO PAYMENT')]")).click();

		System.out.println("Order Placed successfullyy... :)");

		wLib.acceptAlertPopUp(driver);

		driver.findElement(By.xpath("//i[@class='fas fa-laugh-wink']/../../div[contains(.,'Sales and Inventory System')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(.,'Transaction')]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(custName);
		List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
		int count = 0;
		for (WebElement webElement : allNames) {
			String text = webElement.getText();
			if(text.equals(custName)) {
				count++;
				break;

			}

		}
		if(count==1) 
			System.out.println("Transaction is adding in the Transaction Page");
		else
			System.out.println("Transaction is not adding in the Transaction Page");


		driver.findElement(By.id("userDropdown")).click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(.,'Logout') and@class='dropdown-item']"));
		wLib.mouseHoverOnElement(driver, logout);
		logout.click();
		driver.findElement(By.xpath("//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")).click();

		driver.close();

	}
}
