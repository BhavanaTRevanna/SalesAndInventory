package com.TestCases;

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

public class PlacingOrderForMultipleProducts {
	public static void main(String[] args) throws Throwable {

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
		driver.findElement(By.xpath("//a[@href='#motherboard']")).click();
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 1; i <lastRow; i++) {
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
			
		}
		
		for(Entry<String, String> s:map.entrySet()) {
			//driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue());
		}
		
		driver.findElement(By.xpath("//h6[contains(.,'Intel 12th gen mother board')]/../input[@name='addpos']")).click();

		driver.findElement(By.xpath("//a[@href='#processor']")).click();
		driver.findElement(By.xpath("//h6[contains(.,'₱ 55445')]/../input[@name='addpos']")).click();

		String custName = "a z";
		WebElement selectcustomer = driver.findElement(By.name("customer"));
		Select s=new Select(selectcustomer);
		s.selectByVisibleText(custName);

		driver.findElement(By.xpath("//button[contains(.,'SUBMIT')]")).click();
		driver.findElement(By.id("txtNumber")).sendKeys("250");
		driver.findElement(By.xpath("//button[contains(.,'PROCEED TO PAYMENT')]")).click();

		System.out.println("Order Placed successfullyy... :)");

		a.accept();

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
		Actions a2=new Actions(driver);
		a2.moveToElement(logout).click().perform();
		driver.findElement(By.xpath("//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")).click();

		driver.close();

	}
}
