package com.Sales.ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditInventoryPage extends HomePage{

	public EditInventoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchPro;
	
	@FindBy(xpath = "//input[@placeholder='Quantity']")
	private WebElement quantity;
	
	@FindBy(xpath = "//input[@placeholder='On Hand']")
	private WebElement onHand;
	
	@FindBy(xpath = "//button[contains(.,'Update')]")
	private WebElement update;
	
	
	public void selectPro(String productName, WebDriver driver) {
		searchPro.sendKeys(productName);
		List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
		for (WebElement webElement : allNames) {
			String text = webElement.getText();
			if(text.equals(productName)) {

				driver.findElement(By.xpath("//a[contains(.,' View')]")).click();
				driver.findElement(By.xpath("//a[contains(.,' Edit')]")).click();

				break;

			}
		}
		
	}
	public void editPro(WebDriver driver, String quan, String onhand) {
		quantity.clear();
		quantity.sendKeys(quan);
		onHand.clear();
		onHand.sendKeys(onhand);
		update.click();
		System.out.println("Quantity and On hand details updated  successfully... :)");
		acceptAlertPopUp(driver);
		
	}
	

}
