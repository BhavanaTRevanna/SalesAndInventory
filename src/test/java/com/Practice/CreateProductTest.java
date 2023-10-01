package com.Practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateProductTest {
	@Test
	public void createProduct() {
		String BROWSER=System.getProperty("browser");
		 String URL=System.getProperty("url");
		 String USERNAME=System.getProperty("username");
		 String PASSWORD=System.getProperty("password");
		 
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		
		Alert a=driver.switchTo().alert();
		a.accept();
		
		//driver.findElement(By.)
		
		
	}

}
