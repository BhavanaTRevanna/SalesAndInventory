package com.TestCases;

import java.io.FileInputStream;
import java.util.Map.Entry;
import java.time.Duration;
import java.util.HashMap;
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

public class Create_Employee {
	public static void main(String[] args) throws Throwable {
		//to read data from property file
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);

		//to read data from excel file

		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet5");
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
		

		driver.findElement(By.xpath("//span[contains(.,'Employee')]")).click();
		driver.findElement(By.xpath("//h4//i")).click();
		
		Random ran = new Random();
		int random = ran.nextInt();

		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 1; i <=lastRow; i++) {
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);

		}
		for(Entry<String, String> s:map.entrySet()) {
			if(s.getKey().equals("//form[@action='emp_transac.php?action=add']/descendant::input[@placeholder='Phone Number']") || s.getKey().equals("//form[@action='emp_transac.php?action=add']/descendant::input[@placeholder='First Name']"))
			driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue()+random);
			else
			driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue());
		}

		WebElement gender = driver.findElement(By.xpath("//form[@action='emp_transac.php?action=add']/descendant::select[@name='gender']"));
		Select s= new Select(gender);
		s.selectByValue("Female");

		driver.findElement(By.name("email")).sendKeys("bhavanatr@gmail.com");
		//driver.findElement(By.xpath("//form[@action='emp_transac.php?action=add']/descendant::input[@placeholder='Phone Number']")).sendKeys("725857658"+random);


		WebElement job = driver.findElement(By.name("jobs"));
		Select s1= new Select(job);
		s1.selectByValue("1");

		WebElement date = driver.findElement(By.name("hireddate"));
		date.click();
		date.sendKeys("12");
		date.sendKeys("02");
		date.sendKeys("1999");

		WebElement province = driver.findElement(By.name("province"));
		Select s2= new Select(province);
		s2.selectByVisibleText("Aklan");


		driver.findElement(By.xpath("//form[@action='emp_transac.php?action=add']/descendant::button[@class='btn btn-success']")).click();
		System.out.println("Employee created successfully... :)");
        
		driver.findElement(By.id("userDropdown")).click();
		System.out.println("Employee created succesfully...");
		WebElement logout = driver.findElement(By.xpath("//a[contains(.,'Logout') and@class='dropdown-item']"));
		Actions a1=new Actions(driver);
		a1.moveToElement(logout).click().perform();
		driver.findElement(By.xpath("//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")).click();

		driver.close();

	}
}
