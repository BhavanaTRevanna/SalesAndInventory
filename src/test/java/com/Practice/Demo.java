package com.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.netflix.com/in/browse/genre/34399");
		//driver.get("https://www.google.com/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//h2[contains(.,'Popular on Netflix')]/..//span[@class='nm-collections-title-name']"));
		 // driver.findElement(By.id("APjFqb")).sendKeys("netflix movies");
		//List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='NJU16b']"));
		for (WebElement web : allLinks) {
			String text=web.getText();
			System.out.println(text);

		}
	}
}
