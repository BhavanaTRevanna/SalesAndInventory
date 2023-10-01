package TestNG;

import org.testng.annotations.Test;

import com.SalesAndInventory.genericUtils.BaseClass;

public class Demo extends BaseClass{
	
	@Test(groups = "smoke")
	public void demo() {
		System.out.println("demo");
	}
}
