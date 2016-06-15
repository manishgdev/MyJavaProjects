package com.manish.tngfactory;

import org.testng.annotations.Test;

public class TestFactoryExec {
		
	private String testName;
	
	public TestFactoryExec(String testName) {
		this.testName = testName;
	}
	
	@Test
	public void execTest() {
		System.out.println("------------------------------------------");
		System.out.println("Executing the Test '"+testName+"' create from the TestNGFactory");
		System.out.println("------------------------------------------");
	}
}

