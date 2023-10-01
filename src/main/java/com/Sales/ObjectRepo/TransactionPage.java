package com.Sales.ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

public class TransactionPage {

	@FindBy(xpath = "//span[contains(.,'Transaction')]")
	private WebElement transactionBtn;
	
	public WebElement getTransactionBtn() {
		return transactionBtn;
	}

	public WebElement getSearcTtransaction() {
		return searcTtransaction;
	}

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searcTtransaction;

	public TransactionPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void checkTransaction(String custName, WebDriver driver) {
		transactionBtn.click();
		searcTtransaction.sendKeys(custName);
		List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
		int count = 0;
		for (WebElement webElement : allNames) {
			String text = webElement.getText();
			if(text.equals(custName)) {
				count++;
				break;

			}

		}
		assertSame(count, 1, "Transaction is not adding in the Transaction Page");
	
	}
	
	
}
