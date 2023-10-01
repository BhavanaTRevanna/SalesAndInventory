package com.TestCases;

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

import com.mysql.cj.jdbc.Driver;

public class CreateProductTest {
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

		driver.findElement(By.xpath("//span[contains(.,'Product')]")).click();
		driver.findElement(By.xpath("//h4//i")).click();

		String prodName = "CPU"+random;
		driver.findElement(By.name("prodcode")).sendKeys("123"+random);
		driver.findElement(By.name("name")).sendKeys(prodName);
		driver.findElement(By.xpath("//form[@action='pro_transac.php?action=add']//textarea")).sendKeys("CPU");

		driver.findElement(By.name("quantity")).sendKeys("4");
		driver.findElement(By.name("onhand")).sendKeys("4");
		driver.findElement(By.name("price")).sendKeys("2,00,000");

		WebElement category = driver.findElement(By.name("category"));
		Select s=new Select(category);
		s.selectByVisibleText("CPU");



		Thread.sleep(2000);
		WebElement supplier = driver.findElement(By.name("supplier"));
		Select s1=new Select(supplier);
		s1.selectByValue("62");

		WebElement date = driver.findElement(By.name("datestock"));
		date.click();
		date.sendKeys("02");
		date.sendKeys("12");
		date.sendKeys("1999");

		driver.findElement(By.xpath("//form[@action='pro_transac.php?action=add']/descendant::button[@class='btn btn-success']")).click();

		System.out.println("Product added successfully..");

		driver.findElement(By.id("userDropdown")).click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(.,'Logout') and@class='dropdown-item']"));
		Actions a1=new Actions(driver);
		a1.moveToElement(logout).click().perform();
		driver.findElement(By.xpath("//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")).click();
		driver.close();

	}}
