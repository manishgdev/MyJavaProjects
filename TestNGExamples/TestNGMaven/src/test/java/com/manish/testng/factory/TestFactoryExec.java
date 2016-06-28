package com.manish.testng.factory;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.lang.reflect.Method;
import org.testng.ITestResult;

public class TestFactoryExec {
		
	private String testName;
	
	public TestFactoryExec(String testName) {
		this.testName = testName;
	}
	
	@BeforeMethod
    public void beforeMethod(Method m) {
        System.out.println("==========================");
        System.out.println("Going to start execution of Method : '"+m.getName()+"'");
    }
    
    @AfterMethod
    public void afterMethod(ITestResult result) {
        System.out.println("Execution of Method : '"+result.getMethod().getMethodName()+"' completed");
        System.out.println("===========================");
    }
	
	@Test
	public void execTest() {
		System.out.println("Executing the Test '"+testName+"' create from the TestNGFactory");
	}
}

