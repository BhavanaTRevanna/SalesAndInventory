package com.Sales.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage extends HomePage{
	
	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getProdcode() {
		return prodcode;
	}

	public WebElement getProdName() {
		return prodName;
	}

	public WebElement getDescriptionTbx() {
		return descriptionTbx;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getOnhand() {
		return onhand;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getCategory() {
		return category;
	}

	public WebElement getSupplier() {
		return supplier;
	}

	public WebElement getDatestock() {
		return datestock;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	@FindBy(xpath = "//h4//i")
	private WebElement addProductBtn;
	
	@FindBy(name = "prodcode")
	private WebElement prodcode;
	
	@FindBy(name = "name")
	private WebElement prodName;
	
	@FindBy(xpath = "//form[@action='pro_transac.php?action=add']//textarea")
	private WebElement descriptionTbx;
	
	@FindBy(name = "quantity")
	private WebElement quantity;
	
	@FindBy(name = "onhand")
	private WebElement onhand;
	
	@FindBy(name = "price")
	private WebElement price;
	
	@FindBy(name = "category")
	private WebElement category;
	
	@FindBy(name = "supplier")
	private WebElement supplier;
	
	@FindBy(name = "datestock")
	private WebElement datestock;
	
	@FindBy(xpath = "//form[@action='pro_transac.php?action=add']/descendant::button[@class='btn btn-success']")
	private WebElement savebtn;
	
	public CreateProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void createProduct(HashMap<String, String> map, WebDriver driver, String desc, String categ, String supp, String date, String month, String year) {
		clickOnProduct();
		addProductBtn.click();
		for(Entry<String, String> s:map.entrySet()) {
			if(s.getKey().equals("prodcode"))
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue()+getRandomnumber());
			else
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		descriptionTbx.sendKeys(desc);
	    selectDropDown(categ, category);
	    selectDropDown(supplier, supp);
	    datestock.click();
	    datestock.sendKeys(date, month, year);
	    savebtn.click();
	}
	

}
