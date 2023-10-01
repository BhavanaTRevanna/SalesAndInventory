package com.Sales.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SalesAndInventory.genericUtils.JavaUtility;
import com.SalesAndInventory.genericUtils.WebDriverUtility;

public class CreateEmployeePage extends HomePage {
	
	public WebElement getAddEmployee() {
		return addEmployee;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getEmailTf() {
		return emailTf;
	}

	public WebElement getJobs() {
		return jobs;
	}

	public WebElement getHireddate() {
		return hireddate;
	}

	public WebElement getProvince() {
		return province;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath = "//h4//i")
	private WebElement addEmployee;
	
	@FindBy(xpath = "//form[@action='emp_transac.php?action=add']/descendant::input[@placeholder='First Name']")
	private WebElement firstName;
	
	@FindBy(xpath = "//form[@action='emp_transac.php?action=add']/descendant::input[@placeholder='Last Name']")
	private WebElement lastName;
	
	@FindBy(xpath = "//form[@action='emp_transac.php?action=add']/descendant::input[@placeholder='Phone Number']")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "//form[@action='emp_transac.php?action=add']/descendant::select[@name='gender']")
	private WebElement gender;
	
	@FindBy(name = "email")
	private WebElement emailTf;
	
	@FindBy(name = "jobs")
	private WebElement jobs;
	
	@FindBy(name = "hireddate")
	private WebElement hireddate;
	
	@FindBy(name = "province")
	private WebElement province;
	
	@FindBy(xpath = "//form[@action='emp_transac.php?action=add']/descendant::button[@class='btn btn-success']")
	private WebElement saveBtn;
		
	public CreateEmployeePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void createCustomer(HashMap<String, String> map, WebDriver driver, JavaUtility jLib, WebDriverUtility wLib, String gender1, String email, String jobs1, String date, String month, String year, String province1) {
		clickOnEmployee();
		addEmployee.click();
		for(Entry<String, String> s:map.entrySet()) {
			if(s.getKey().equals("//form[@action='emp_transac.php?action=add']/descendant::input[@placeholder='Phone Number']") || s.getKey().equals("//form[@action='emp_transac.php?action=add']/descendant::input[@placeholder='First Name']") || s.getKey().equals("phonenumber") || s.getKey().equals("companyname"))
				driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue()+jLib.getRandomnumber());
			else
				driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue());
		}
		
		wLib.selectDropDown(gender, gender1);
		emailTf.sendKeys(email);
		wLib.selectDropDown(jobs, jobs1);
		hireddate.click();
		hireddate.sendKeys(date, month, year);
		
		wLib.selectDropDown(province1, province);
		saveBtn.click();
		System.out.println("Employee added successfully...");
	}
}

