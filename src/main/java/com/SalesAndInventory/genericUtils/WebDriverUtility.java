package com.SalesAndInventory.genericUtils;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Bhavana
 *
 */
public class WebDriverUtility extends JavaUtility{
	/**
	 * it will maximize the browser 
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * it will minimize the browser 
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver) {
		driver.manage().window().minimize();;
	}
	/**
	 * this method will wait until elements in the page gets loaded
	 * @param driver
	 * @param duration
	 */
	public void implicitlyWait(WebDriver driver, int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	/**
	 * this method will wait until the url of the page gets loaded
	 * @param driver
	 * @param duration
	 * @param expectedUrl
	 */
	public void waitUntilUrlLoads(WebDriver driver, int duration, String expectedUrl) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedUrl));
	}
	/**
	 * this method will wait until the title of the page gets loaded
	 * @param driver
	 * @param duration
	 * @param expectedTitle
	 */
	public void waitUntilTiltleLoads(WebDriver driver, int duration, String expectedTitle) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
	}
	/**
	 * this method will wait until the element in the page gets loaded
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntilElementToBeClickable(WebDriver driver, int duration, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method will ignore the NoSuchElementException and continues the execution
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver, int duration) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * this method will wait until the element to be visible in the page (custom wait)
	 * @param element
	 * @throws Throwable
	 */
	public void customWait(WebElement element) throws Throwable {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			}

			catch (Exception e) {
				Thread.sleep(1000);
				count++;	
			}
		}
	}
	/**
	 * this method will select the dropdown element based on the index 
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * this method will select the dropdown element based on the value 
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method will select the dropdown element based on the visible text 
	 * @param element
	 * @param index
	 */
	public void selectDropDown( String text, WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * this method is used to mouseHover on an  element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * this method is used to mouseHover on an  element and click on it
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElementAndClick(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	/**
	 * this method is used to rightclick on the element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * this method is used to click on enter button
	 * @param driver
	 * @throws Throwable 
	 */
	public void clickOnEnterKey(WebDriver driver) throws Throwable {
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		/* Robot rb=new Robot();
	    rb.keyPress(KeyEvent.VK_ENTER);*/
	}
	/**
	 * this method is used to release the enter key
	 * @param driver
	 * @throws Throwable 
	 */
	public void clickOnEnterRelease(WebDriver driver) throws Throwable {
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * this method is used to switch from one frame to another using index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used to switch from one frame to another using id
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}
	/**
	 * this method is used to switch from one frame to another using webelement
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * this method is used to switch from one frame to it's parent frame
	 * @param driver
	 * @param index
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * this method is used to switch from one frame to main frame
	 * @param driver
	 * @param index
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * this method is used to accept alert popup
	 * @param driver
	 * @param expectedMsg
	 */
	public void acceptAlertPopUp(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
//		if(alt.getText().equalsIgnoreCase(expectedMsg)) {
//			System.out.println("alert msg is verified");
//		}
//		else {
//			System.out.println("alert msg is not verified");
//		}
	alt.accept();
		//driver.switchTo().alert().accept();
	}
	/**
	 * this method is used to dismiss alert popup
	 * @param driver
	 * @param expectedMsg
	 */
	public void dismissAlertPopUp(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
//		if(alt.getText().equalsIgnoreCase(expectedMsg)) {
//			System.out.println("alert msg is verified");
//		}
//		else {
//			System.out.println("alert msg is not verified");
//		}
		alt.dismiss();
		//driver.switchTo().alert().dismiss();
	}
	/**
	 * this method is used to switch from one window to another using title 
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchWindowBasedOnTitle(WebDriver driver, String expectedTitle) {
		Set<String> set = driver.getWindowHandles();
		for(String string:set) {
			driver.switchTo().window(string);
			String title=driver.getTitle();
			if(title.contains(expectedTitle)) {
				break;
			}
		}
	}
	/**
	 * this method is used to switch from one window to another using title 
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchWindowBasedOnUrl(WebDriver driver, String expectedUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator< String> it=set.iterator();
		while(it.hasNext()) {
			String wid=it.next();
			driver.switchTo().window(wid);
			String url=driver.getCurrentUrl();
			if(url.contains(expectedUrl))
				break;
		}
	}
	/**
	 * this method will take screenshot whenever the testscript gets failed
	 * @return 
	 */
	public String takesScreenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screensot/"+screenshotName+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotName;
	}
	/**
	 * this method is used to scroll to a particular element/element found
	 * @param driver
	 * @param element
	 */
	public void scrollToParticularElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView()", element);
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	/**
	 * this method is used perform random scroll 
	 * @param driver
	 * @param element
	 */
	public void scrollToBarAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
	}

}
