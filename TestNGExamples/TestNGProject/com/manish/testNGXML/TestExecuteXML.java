package com.manish.testNGXML;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class TestExecuteXML {


	@AfterMethod
	public void afterTestMethod(ITestResult result) {
		System.out.println("Executed Method :- "+result.getMethod().getMethodName());
	}
	
	@BeforeMethod
	public void beforeMethod(ITestContext context) {
		// This gives ConfigurationFailure if the ITestResult Object is used in the Before method
		// No harm in passing the ITestResult Object as the parameter but when it is used in the method body then it gives ConfigurationFailure
		// System.out.println("Inside before Method :- "+result.getMethod().getMethodName());
		
		// Use the ITestContext object here
		System.out.println("Context of the Test Execution : "+context);
	}
	
	@Test
	public void testMethod() {
		System.out.println("Executing Test Method from com.manish.testNGXML package");
	}
}
