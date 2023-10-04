package com.Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class CaptchaIrctc {
	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//a[contains(.,' LOGIN ')]")).click();
		WebElement captcha = driver.findElement(By.xpath("//img[@class='captcha-img']"));
		File src = captcha.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\Admin\\eclipse-workspace\\com.SalesAndInventory\\screensot\\captcha.png";
		FileUtils.copyFile(src, new File(path));
		
		ITesseract ts=new Tesseract();
		ts.setDatapath("C:\\Users\\Admin\\Desktop\\Tess4J\\tessdata");
		String captchaText=ts.doOCR(new File(path));
		String actualText=captchaText.toString().trim().replace(" ", "");
		driver.findElement(By.id("captcha")).sendKeys(actualText);
	}
}
