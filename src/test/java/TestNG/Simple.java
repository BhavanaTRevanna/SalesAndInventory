package TestNG;

import org.testng.annotations.Test;

import com.SalesAndInventory.genericUtils.BaseClass;

public class Simple extends BaseClass {

	@Test(groups = "smoke")
	public void simple() {
		System.out.println("simple");
	}
}
