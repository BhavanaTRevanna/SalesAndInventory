package com.SalesAndInventory.genericUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class IAnnTrans implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
	annotation.setRetryAnalyzer(com.SalesAndInventory.genericUtils.RetryImpl.class);
	}
	

}
