package com.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CalenderPopupTest {

	public static void main(String[] args) {
      WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.ksrtc.in/");
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
       int date=31;
       driver.findElement(By.id("txtJourneyDate")).click();
       driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/descendant::a[.='"+date+"']")).click();
	}

}
		