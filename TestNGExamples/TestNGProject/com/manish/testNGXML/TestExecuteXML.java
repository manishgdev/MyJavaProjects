package com.manish.testNGXML;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import org.testng.ITestResult;
import org.testng.ITestContext;

public class TestExecuteXML {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite Method Executed");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite Method Executed");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test Method Executed");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test method executed");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Class Method Executed");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("After Class Method Executed");
	}
	
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
