package com.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class WordToPdf {
	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ilovepdf.com/");
		Screen s=new Screen();
		driver.findElement(By.xpath("//h3[contains(.,'Word to PDF')]/preceding-sibling::div[@class='tools__item__icon']")).click();
		driver.findElement(By.xpath("//span[contains(.,'Select WORD files')]")).click();
		Pattern p = new Pattern("C:\\Users\\Admin\\eclipse-workspace\\com.SalesAndInventory\\screensot\\Folder.png");
		s.type(p, "abcd");
	}

}
