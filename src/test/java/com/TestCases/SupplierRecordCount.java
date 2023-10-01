package com.TestCases;

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

import com.Sales.ObjectRepo.HomePage;
import com.Sales.ObjectRepo.LoginPage;

public class SupplierRecordCount {
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
		
		
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD, driver);
		
		HomePage hp=new HomePage(driver);
//		driver.findElement(By.name("user")).sendKeys(USERNAME);
//		driver.findElement(By.name("password")).sendKeys(PASSWORD);
//		driver.findElement(By.name("btnlogin")).click();

		Alert a=driver.switchTo().alert();
		a.accept();
		String record = driver.findElement(By.xpath("//div[contains(.,'Supplier')]/div[@class='h6 mb-0 font-weight-bold text-gray-800']")).getText();
		System.out.println(record);

		String comName = "Livspace"+random;
		driver.findElement(By.xpath("//span[contains(.,'Supplier')]")).click();
		driver.findElement(By.xpath("//h4//i")).click();
		driver.findElement(By.name("companyname")).sendKeys(comName);
		WebElement province = driver.findElement(By.id("province"));
		Select s=new Select(province);
		s.selectByVisibleText("Bohol");

		driver.findElement(By.name("phonenumber")).sendKeys("6568475");


		driver.findElement(By.xpath("//form[@action='sup_transac.php?action=add']/descendant::button[@class='btn btn-success']")).click();

		driver.findElement(By.xpath("//span[contains(.,'Home')]")).click();

		String erecord = driver.findElement(By.xpath("//div[contains(.,'Supplier')]/div[@class='h6 mb-0 font-weight-bold text-gray-800']")).getText();
		System.out.println(erecord);

		if (record.equals(erecord)) {
			System.out.println("supplier count is not changing");
		}
		else
			System.out.println("supplier count is changing");
		
		hp.logout(driver);

//		driver.findElement(By.id("userDropdown")).click();
//		WebElement logout = driver.findElement(By.xpath("//a[contains(.,'Logout') and@class='dropdown-item']"));
//		Actions a1=new Actions(driver);
//		a1.moveToElement(logout).click().perform();
//		driver.findElement(By.xpath("//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")).click();
//
//		driver.close();

	}

}
