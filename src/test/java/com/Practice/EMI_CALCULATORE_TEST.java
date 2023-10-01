package com.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EMI_CALCULATORE_TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://emicalculator.net/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions a=new Actions(driver);
		a.scrollByAmount(3000, 0);
		
		List<WebElement> text = driver.findElements(By.xpath("//*[name()='tspan']/ancestor::*[name()='text' and @style='color:#333333;cursor:default;font-size:12px;fill:#333333;']"));
        for (WebElement webElement : text) {
			String text1 = webElement.getText();
			System.out.println(text1);
		}
	}

}
