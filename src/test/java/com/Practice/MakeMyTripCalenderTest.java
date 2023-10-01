package com.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripCalenderTest {

	public static void main(String[] args) throws InterruptedException {
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.makemytrip.com/");
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    Thread.sleep(10000);
    Actions a=new Actions(driver); 
    a.doubleClick().perform();
    String MonthAndYear="November 2023";
    int date=18;
    Thread.sleep(3000);
    a.moveByOffset(0, 80).click().perform();
    driver.findElement(By.xpath("//span[.='Departure']")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//div[.='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']")).click();
   // "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"
	}

}
