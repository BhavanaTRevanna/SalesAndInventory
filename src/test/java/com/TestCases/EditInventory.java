package com.TestCases;

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

public class EditInventory {

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

		a.accept();



		driver.findElement(By.id("userDropdown")).click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(.,'Logout') and@class='dropdown-item']"));
		Actions a2=new Actions(driver);
		a2.moveToElement(logout).click().perform();
		driver.findElement(By.xpath("//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")).click();
		driver.close();

	}

}
