package com.Practice;

import java.io.File;

import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class Captcha {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://myaadhaar.uidai.gov.in/");
		driver.findElement(By.xpath("//button[@class='button_btn__1dRFj']")).click();
		Thread.sleep(5000);
		WebElement captcha = driver.findElement(By.xpath("//div[@id='captcha_block']//img"));
		File src = captcha.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\Admin\\eclipse-workspace\\com.SalesAndInventory\\screensot\\captcha.png";
		FileUtils.copyFile(src, new File(path));
		
		ITesseract ts=new Tesseract();
		ts.setDatapath("C:\\Users\\Admin\\Desktop\\Tess4J\\tessdata");
		String captchaText=ts.doOCR(new File(path));
		String actualText=captchaText.toString().trim().replace(" ", "");
		System.out.println(actualText);
		

	}

}
