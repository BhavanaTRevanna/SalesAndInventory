package com.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SpicejetTest {

	public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Thread.sleep(10000);
        int date =11;
        String Month = "September";
        int Year = 2023;
        int returnDate =20;
        String rMonth = "October";
        int rYear = 2023;
        int adult = 5;
         driver.findElement(By.xpath("//div[@class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2' and contains(.,'To')]")).click();  
         driver.findElement(By.xpath("//div[contains(.,'Delhi') and @class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79']")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//div[contains(.,'"+Month+"') and contains(.,'"+Year+"') and @class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/div[@class='css-1dbjc4n']/descendant::div[contains(.,'"+date+"') and @class='css-1dbjc4n r-1awozwy r-14lw9ot r-1loqt21 r-eu3ka r-1otgn73 r-1aockid']")).click();
         Thread.sleep(5000);
         driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']")).click();
	     driver.findElement(By.xpath("//div[contains(.,'"+rMonth+"') and contains(.,'"+rYear+"') and @class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/div[@class='css-1dbjc4n']/descendant::div[contains(.,'"+returnDate+"') and @class='css-1dbjc4n r-1awozwy r-14lw9ot r-1loqt21 r-eu3ka r-1otgn73 r-1aockid']")).click();
	     Thread.sleep(5000);
	     /*driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73' and contains(.,'Passengers')]")).click();
	     for (int i = 1; i < adult; i++) {
		 driver.findElement(By.xpath("//div[contains(.,'Adult') and @class='css-76zvg2 r-homxoj r-1i10wst r-1kfrs79']/ancestor::div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1x0uki6']//div[@class='r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-1i6wzkk r-lrvibr r-1aockid css-1dbjc4n']")).click();	
	     //driver.findElement(By.xpath("//div[contains(.,'Adult') and @class='css-76zvg2 r-homxoj r-1i10wst r-1kfrs79']/ancestor::div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1x0uki6']//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid']")).click();
	     }*/
	     
	     driver.findElement(By.xpath("//div[.='Passengers']")).click();
			for(int i=1;i<adult;i++)
			{
				driver.findElement(By.xpath("//div[.='Adult']/ancestor::div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1x0uki6']/descendant::div[@data-testid='Adult-testID-plus-one-cta']")).click();
			}
			
			driver.findElement(By.xpath("//div[.='Currency']")).click();
			driver.findElement(By.xpath("//div[.='USD']")).click();
			
			Actions a=new Actions(driver);
			a.doubleClick(driver.findElement(By.xpath("//div[text()='Search Flight']"))).perform();
			
			List<WebElement> departureList = driver.findElements(By.xpath("//div[text()='Select your' and text()='Departure to']/ancestor::div[@id='list-results-section-0']/descendant::div[@class='css-1dbjc4n r-13awgt0 r-18u37iz r-b5h31w r-1ah4tor r-tvv088']/descendant::div[@class='css-76zvg2 r-homxoj r-1i10wst']"));
			Thread.sleep(2000);
			if(departureList.size()>0)
			{
				System.out.println("List of departuring flights");
				for(WebElement e2:departureList)
				{
					System.out.println(e2.getText());
				}
			}
			else
				System.out.println("Currently departure flights are not available for the given date");
			
			
			
			List<WebElement> returnList = driver.findElements(By.xpath("//div[text()='Select your' and text()='Return Flight to']/ancestor::div[@id='list-results-section-1']/descendant::div[@class='css-1dbjc4n r-13awgt0 r-18u37iz r-b5h31w r-1ah4tor r-tvv088']/descendant::div[@class='css-76zvg2 r-homxoj r-1i10wst']"));
			Thread.sleep(2000);
			if(returnList.size()>0)
			{
				System.out.println("List of return flights");
				for(WebElement e2:returnList)
				{
					System.out.println(e2.getText());
				}
			}
			else
				System.out.println("Currently return flights are not avaialble for the given date");
			driver.quit();
	}

}
