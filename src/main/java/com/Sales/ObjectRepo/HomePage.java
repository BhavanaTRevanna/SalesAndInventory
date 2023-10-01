package com.Sales.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SalesAndInventory.genericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	@FindBy(xpath = "//span[contains(.,'Home')]")
	private WebElement homeBtn;
	
	@FindBy(xpath = "//span[contains(.,'Employee')]")
	private WebElement employeeBtn;
	
	@FindBy(xpath = "//span[contains(.,'POS')]")
	private WebElement posBtn;
	
	@FindBy(xpath = "//div[contains(.,'Supplier')]/div[@class='h6 mb-0 font-weight-bold text-gray-800']")
	private WebElement supplierCount;
	
	@FindBy(xpath = "//span[contains(.,'Supplier')]")
	private WebElement supplierbtn;
	
	public WebElement getSupplierbtn() {
		return supplierbtn;
	}

	@FindBy(xpath = "//span[contains(.,'Inventory')]")
	private WebElement inventoryBtn;
	
	@FindBy(xpath = "//span[contains(.,'Product')]")
	private WebElement productBtn;
	
	@FindBy(id="userDropdown")
	private WebElement profileBtn;
	
	@FindBy(xpath = "//a[contains(.,'Logout') and@class='dropdown-item']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//a[contains(.,'Logout') and @class='btn btn-primary' and@href='logout.php']")
	private WebElement logout;
	
	@FindBy(xpath = "//span[contains(.,'Transaction')]")
	private WebElement transactionBtn;

	public WebElement getTransactionBtn() {
		return transactionBtn;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getEmployeeBtn() {
		return employeeBtn;
	}

	public WebElement getPosBtn() {
		return posBtn;
	}

	public WebElement getSupplierCount() {
		return supplierCount;
	}

	public WebElement getInventoryBtn() {
		return inventoryBtn;
	}

	public WebElement getProductBtn() {
		return productBtn;
	}

	public WebElement getProfileBtn() {
		return profileBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getLogout() {
		return logout;
	}
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getSupplierRecordCount() {
		String count = supplierCount.getText();
		return count;
	}
	
	public void logout(WebDriver driver) {
		profileBtn.click();
		mouseHoverOnElementAndClick(driver, logoutBtn);
		logout.click();
	}
	public void clickOnEmployee() {
		employeeBtn.click();
	}
	public void clickOnProduct() {
		productBtn.click();
	}
	public void clickIventory() {
		inventoryBtn.click();
	}
	public void clickOnPOS() {
		posBtn.click();
	}
	public String supplierCount() {
		String count = supplierCount.getText();
		return count;
	}
	public void clickOnHome() {
		homeBtn.click();
	}
	
}
