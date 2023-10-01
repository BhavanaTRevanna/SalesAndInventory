package com.Sales.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SalesAndInventory.genericUtils.WebDriverUtility;


public class LoginPage extends WebDriverUtility{
	
	@FindBy(name="user")
	private WebElement usrtf;
	
	@FindBy(name="password")
	private WebElement pwdtf;
	
	@FindBy(name="btnlogin")
	private WebElement lgnbtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsrtf() {
		return usrtf;
	}

	public WebElement getPwdtf() {
		return pwdtf;
	}

	public WebElement getLgnbtn() {
		return lgnbtn;
	}
	
	public void login(String USERNAME,String PASSWORD, WebDriver driver) {
		usrtf.sendKeys(USERNAME);
		pwdtf.sendKeys(PASSWORD);
		lgnbtn.click();
		acceptAlertPopUp(driver);
	}
	
}
