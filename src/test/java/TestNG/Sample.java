package TestNG;

import org.testng.annotations.Test;

import com.SalesAndInventory.genericUtils.BaseClass;

public class Sample extends BaseClass{

	@Test(groups = "regression")
	public void sample() {
		System.out.println("sample");
	}
}
