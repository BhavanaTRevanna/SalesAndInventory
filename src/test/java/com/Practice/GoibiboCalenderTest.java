package com.Practice;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboCalenderTest {

	public static void main(String[] args) {
     WebDriver driver= new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.goibibo.com/");
     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
     String MonthAndYear="November 2023";
     int date=18;
     driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
     driver.findElement(By.xpath("//span[.='Departure']")).click();
     //driver.findElement(By.xpath("//div[.='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']")).click();
  String actual = "//div[.='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
  String nextArrow = "//span[@aria-label='Next Month']";
  for(;;) {
	  try {
		  
		driver.findElement(By.xpath(actual)).click();
		break;
	} 
	  catch (Exception e) {
		  driver.findElement(By.xpath(nextArrow)).click();
		  
	}
  }
  driver.findElement(By.xpath("//span[.='Done']")).click();
     
	}

}
