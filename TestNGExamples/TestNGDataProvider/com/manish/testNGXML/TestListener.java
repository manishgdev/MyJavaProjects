package com.manish.testNGXML;

import org.testng.TestListenerAdapter;
import org.testng.ITestResult;

public class TestListener extends TestListenerAdapter {
	
	public void onConfigurationFailure(ITestResult result) {
		System.out.println("Configuration Failure Occured");
		//System.out.println(result.getThrowable());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failure Occured");
		//System.out.println(result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped");
		System.out.println(result.getThrowable());
	}
}
