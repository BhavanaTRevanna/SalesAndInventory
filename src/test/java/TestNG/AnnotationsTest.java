package TestNG;



import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsTest {
	
	@BeforeSuite
	public void confgBS() {
		System.out.println("----to connect database---");
	}
	
	@BeforeClass
	public void confgBC() {
		System.out.println("----open the browser----");
	}
	
	@BeforeMethod
	public void confgBM() {
		System.out.println("----login to appl----");
	}
	
	@Test(dependsOnMethods = {"createEmployee", "editEmployee"})
	public void deleteEmployee() {
		System.out.println("---- Delete Employee---");
	}
	
	@AfterMethod
	public void confgAM() {
		System.out.println("---logout from the appl----");
	}

	@AfterClass
	public void confgAC() {
		System.out.println("---close the broswer---");
	}
	
	@AfterSuite
	public void confgAS() {
		System.out.println("---Disconnect the database---");
	}
	
	@Test(dependsOnMethods = "createEmployee", invocationCount = 2)
	public void editEmployee() {
		System.out.println("---Edit Employee---");
	}
	
	@Test
	public void createEmployee() {
		System.out.println("---Create Employee---");
	}
}
