package TestNG;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	@Test
	public void softAssert() {
		SoftAssert sa=new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		sa.assertSame("A", "B");
		System.out.println("Step-3");
		System.out.println("Step-4");
		sa.assertAll();
	}
}
