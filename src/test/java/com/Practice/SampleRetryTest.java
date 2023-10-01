package com.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SalesAndInventory.genericUtils.BaseClass;

public class SampleRetryTest extends BaseClass{

	@Test(retryAnalyzer = com.SalesAndInventory.genericUtils.RetryImpl.class)
	public void retryTest() {
		Assert.assertNotSame("a", "a");
	}
}
