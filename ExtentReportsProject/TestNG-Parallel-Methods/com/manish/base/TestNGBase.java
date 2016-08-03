package com.manish.base;

import org.testng.annotations.AfterMethod;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterSuite;
import java.lang.reflect.Method;
import com.manish.extent.ExtentTestManager;

import com.relevantcodes.extentreports.LogStatus;

public class TestNGBase {
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		ExtentTestManager.startTest(method.getName());
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
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
	
	@AfterSuite
	public void afterSuite() {
		ExtentTestManager.close();
	}
}
