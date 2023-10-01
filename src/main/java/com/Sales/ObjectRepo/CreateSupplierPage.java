package com.Sales.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateSupplierPage extends HomePage{
	
	@FindBy(name = "companyname")
	private WebElement companyname;
	
	
	@FindBy(name = "phonenumber")
	private WebElement phonenumber;
	
	@FindBy(xpath = "//h4//i")
	private WebElement addEmployee;
	
	@FindBy(id = "province")
	private WebElement province;
	
	@FindBy(xpath = "//form[@action='sup_transac.php?action=add']/descendant::button[@class='btn btn-success']")
	private WebElement saveBtn;
	
	

	public CreateSupplierPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void createSupplier(HashMap<String, String> map, WebDriver driver, String province1) {
		getSupplierbtn().click();
		addEmployee.click();
		for(Entry<String, String> s:map.entrySet()) {
			if(s.getKey().equals("phonenumber") || s.getKey().equals("companyname"))
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+getRandomnumber());
			else
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		selectDropDown(province1, province);
		saveBtn.click();
	}
	
	

}
