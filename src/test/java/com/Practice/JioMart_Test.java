package com.Practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMart_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.jiomart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	driver.findElement(By.xpath("//a[contains(.,'Groceries')]")).click();
		/*Actions a=new Actions(driver);
		a.moveToElement(target).perform();
*/
	//driver.findElement(By.xpath("//div[@class='accordion-outer top_category_list jm-list category-content-title']"));
	
	List<WebElement> allText = driver.findElements(By.xpath("//div[@class='accordion-outer top_category_list jm-list category-content-title']/ancestor::div[@class='accordion-wrapper']/descendant::div[@class='jm-list category-content-text-list-item']"));
         System.out.println(allText .size());
	for (WebElement webElement : allText) {
		String text = webElement.getText();
		System.out.println(text);
		
	}
	//driver.close();
	
	}
	

}
