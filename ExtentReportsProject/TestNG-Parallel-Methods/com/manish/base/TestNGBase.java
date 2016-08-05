package com.manish.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;
import org.testng.ITestResult;
import org.testng.ITestContext;
import java.lang.reflect.Method;
import com.manish.extent.ExtentTestManager;

import com.relevantcodes.extentreports.LogStatus;

public class TestNGBase {
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		ExtentTestManager.startTest(method.getName());
		System.out.println("BeforeMethod :- '"+method.getName()+"' & Thread ID :- "+Thread.currentThread().getId());
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		System.out.println("AfterMethod :- '"+ result.getMethod().getMethodName() +"' & Thread ID :- "+Thread.currentThread().getId());
		if(result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.getTest().log(LogStatus.PASS, "ThreadId: " + Thread.currentThread().getId(), "TestCase : '"+result.getMethod().getMethodName()+"' : passed");
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "ThreadId: " + Thread.currentThread().getId(), "TestCase : '"+result.getMethod().getMethodName()+"' : passed");
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(LogStatus.SKIP, "ThreadId: " + Thread.currentThread().getId(), "TestCase : '"+result.getMethod().getMethodName()+"' : passed");
		}
		
		ExtentTestManager.endTest();
	}
	
	@BeforeTest
	public void beforeTestMethod(ITestContext context) {
		System.out.println("Inside Before Test Method :- Thread Id :- "+Thread.currentThread().getId() + " & Test Name :- "+context.getCurrentXmlTest().getName());
	}
	
	@AfterTest
	public void afterTestMethod(ITestContext context) {
		System.out.println("Inside After Test Method :- Thread Id :- "+Thread.currentThread().getId());
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentTestManager.close();
		System.out.println("Inside After Suite Method :- Thread Id :- "+Thread.currentThread().getId());
	}
}
