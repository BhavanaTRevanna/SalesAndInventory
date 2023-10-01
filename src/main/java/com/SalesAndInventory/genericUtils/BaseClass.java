package com.SalesAndInventory.genericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.Sales.ObjectRepo.HomePage;
import com.Sales.ObjectRepo.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public DatabaseUtility dLib=  new DatabaseUtility();
	public JavaUtility jLib=new JavaUtility();

	@BeforeSuite(alwaysRun = true)
	public void confgBS() throws Throwable {
		dLib.connectToDB();
		System.out.println("----to connect database---");
	}
	@BeforeClass(alwaysRun = true)
	public void confgBC() throws Throwable {
		String BROWSER = fLib.getPropertyKeyValue("browser");
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else 
			System.out.println("Invalid Input");

		sdriver=driver;
		wLib.maximizeTheBrowser(driver);

		wLib.implicitlyWait(driver, 10);
		System.out.println("----open the browser----");
	}
	@BeforeMethod(alwaysRun = true)
	public void confgBM() throws Throwable {

		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD =fLib.getPropertyKeyValue("password");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD, driver);
		System.out.println("----login to appl----");
	}
	@AfterMethod(alwaysRun = true)
	public void confgAM() {
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		System.out.println("---logout from the appl----");
	}
	@AfterClass(alwaysRun = true)
	public void confgAC() {
		driver.quit();
		System.out.println("---close the broswer---");
	}
	@AfterSuite(alwaysRun = true)
	public void confgAS() throws Throwable {
		dLib.closeDB();
		System.out.println("---Disconnect the database---");
	}
}
