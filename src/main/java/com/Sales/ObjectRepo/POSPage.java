package com.Sales.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POSPage extends HomePage{
	
	public WebElement getSelectKeyboard() {
		return selectKeyboard;
	}



	public WebElement getSelectProcessor() {
		return selectProcessor;
	}



	public WebElement getKeyboardBtn() {
		return keyboardBtn;
	}



	public WebElement getMotherBoardbtn() {
		return motherBoardbtn;
	}



	public WebElement getProcessorBtn() {
		return processorBtn;
	}



	public WebElement getCPUBtn() {
		return CPUBtn;
	}



	public WebElement getAddCustomerBtn() {
		return addCustomerBtn;
	}



	public WebElement getFirstNameOfCustomer() {
		return firstNameOfCustomer;
	}



	public WebElement getLastNameOfCustomer() {
		return lastNameOfCustomer;
	}



	public WebElement getPhoneNumber() {
		return phoneNumber;
	}



	public WebElement getSaveBtn() {
		return saveBtn;
	}



	public WebElement getSelectcustomerTf() {
		return selectcustomerTf;
	}



	public WebElement getSubmitBtn() {
		return submitBtn;
	}



	public WebElement getPrice() {
		return price;
	}



	public WebElement getProceedTopayBtn() {
		return proceedTopayBtn;
	}
	public WebElement getSelectmotherboard() {
		return selectmotherboard;
	}



	public WebElement getBackToHomePage() {
		return backToHomePage;
	}
	public WebElement getAddCustomer() {
		return addCustomer;
	}



	public WebElement getFirstName() {
		return firstName;
	}



	public WebElement getLastName() {
		return LastName;
	}



	public WebElement getPhoneNum() {
		return phoneNum;
	}

	
	@FindBy(xpath = "//a[@data-target='#keyboard']")
	private WebElement keyboardBtn;
	
	@FindBy(xpath = "//a[@href='#motherboard']")
	private WebElement motherBoardbtn;
	
	@FindBy(xpath = "//a[@href='#processor']")
	private WebElement processorBtn;
	
	@FindBy(xpath = "//a[@href='#cpu']")
	private WebElement CPUBtn;
	
	@FindBy(xpath = "//a[@class='btn btn-primary bg-gradient-primary']")
	private WebElement addCustomerBtn;
	
	@FindBy(xpath = "//form[@action='cust_pos_trans.php?action=add']//input[@name='firstname']")
	private WebElement firstNameOfCustomer;
	
	@FindBy(xpath = "//form[@action='cust_pos_trans.php?action=add']//input[@name='lastname']")
	private WebElement lastNameOfCustomer;
	
	@FindBy(xpath = "//form[@action='cust_pos_trans.php?action=add']//input[@name='phonenumber']")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "//form[@action='cust_pos_trans.php?action=add']//button[@class='btn btn-success']")
	private WebElement saveBtn;
	
	@FindBy(name = "customer")
	private WebElement selectcustomerTf;
	
	@FindBy(xpath = "//button[contains(.,'SUBMIT')]")
	private WebElement submitBtn;
	
	@FindBy(id = "txtNumber")
	private WebElement price;
	
	@FindBy(xpath = "//button[contains(.,'PROCEED TO PAYMENT')]")
	private WebElement proceedTopayBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Intel 12th gen mother board')]/../input[@name='addpos']")
	private WebElement selectmotherboard;
	
	@FindBy(xpath = "//h6[contains(.,'₱ 55445')]/../input[@name='addpos']")
	private WebElement selectProcessor;
	
	@FindBy(xpath = "//h6[contains(.,'Newmen E120')]/../input[@name='addpos']")
	private WebElement selectKeyboard;
	
	@FindBy(xpath = "//i[@class='fas fa-laugh-wink']/../../div[contains(.,'Sales and Inventory System')]")
	private WebElement backToHomePage;
	
	@FindBy(xpath = "//a[@class='btn btn-primary bg-gradient-primary']")
	private WebElement addCustomer;
	
	@FindBy(xpath = "//form[@action='cust_pos_trans.php?action=add']//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath = "//form[@action='cust_pos_trans.php?action=add']//input[@name='lastname']")
	private WebElement LastName;
	
	@FindBy(xpath = "//form[@action='cust_pos_trans.php?action=add']//input[@name='phonenumber']")
	private WebElement phoneNum;
	
	public POSPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void orderPlacingByCreatingCustomer(String firstname, String lastname, String phonenum, int price1, WebDriver driver) {
		getPosBtn().click();
		keyboardBtn.click();
		selectKeyboard.click();
		addCustomer.click();
		firstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
        phoneNum.sendKeys(phonenum);
		saveBtn.click();
		selectDropDown(firstname+" "+lastname, selectcustomerTf);
		submitBtn.click();
		price.sendKeys(""+price1+" ");
		proceedTopayBtn.click();
		System.out.println("Order Placed Successfully... :)");
		acceptAlertPopUp(driver);
		backToHomePage.click();
	}
	
	public void orderMultipleProduct(String custName, int price1, WebDriver driver) {
		getPosBtn().click();
		motherBoardbtn.click();
		selectmotherboard.click();
		processorBtn.click();
		selectProcessor.click();
		selectDropDown(custName, selectcustomerTf);
		submitBtn.click();
		price.sendKeys(""+price1+" ");
		proceedTopayBtn.click();
		System.out.println("Order Placed Successfully... :)");
		acceptAlertPopUp(driver);
		backToHomePage.click();
		
	}



	public void selectProduct(String product) {
		if(product.contains("keyboard"))
			keyboardBtn.click();
		else if (product.contains("Motherboard")) 
			motherBoardbtn.click();
	    else if (product.contains("Motherboard")) 
				motherBoardbtn.click();
	    else if (product.contains("CPU")) 
	    	CPUBtn.click();	
	    else if (product.contains("processor")) 
	    	processorBtn.click();	
		}
		
	public void orderProduct(String custName, int price1, WebDriver driver) {
		getPosBtn().click();
		keyboardBtn.click();
		selectKeyboard.click();
		selectDropDown(custName, selectcustomerTf);
		submitBtn.click();
		price.sendKeys(""+price1+" ");
		proceedTopayBtn.click();
		System.out.println("Order Placed Successfully... :)");
		acceptAlertPopUp(driver);
	}
	
}
