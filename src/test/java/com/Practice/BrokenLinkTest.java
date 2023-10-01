package com.Practice;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) {
     WebDriver driver= new ChromeDriver();
     driver.manage().window().maximize();
    
     driver.get("https://www.india.gov.in/");
     
     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
     List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
     System.out.println(allLinks.size());
     
    ArrayList<String> link = new ArrayList<String>();
    int count1=0;
    for (int i = 0; i <allLinks.size(); i++) {
    	String eachLink=allLinks.get(i).getAttribute("href");
    	
    	URL url=null;
    	int statusCode=0;
    	
    	try {
    		
    		url=new URL(eachLink);
    		HttpsURLConnection httpConn = (HttpsURLConnection) url.openConnection();
    		
    		statusCode=httpConn.getResponseCode();
    		
    		if(statusCode>=400) {
    			link.add(eachLink+"==>"+statusCode);
    			count1++;
    			System.out.println(eachLink);
    		}
			
		} catch (Exception e) {
			link.add(eachLink);
		}
		
	}
    System.out.println(count1);
    driver.close();
	}

}
