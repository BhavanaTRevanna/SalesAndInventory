package TestNG;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTest {

	@Test(invocationCount = 2)
	public void createEmployee() {
		System.out.println("employee created successfully...");
		Assert.fail();
	}
	
	@Test(dependsOnMethods = "createEmployee")
	public void modifyEmployee() {
		System.out.println("employee modification done..");
	}
	
	@Test(priority = 1)
	public void deleteEmployee() {
		System.out.println("employee deleted successfully..");
	}
}
