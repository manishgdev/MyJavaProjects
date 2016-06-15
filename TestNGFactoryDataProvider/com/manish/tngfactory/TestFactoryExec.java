package com.manish.tngfactory;

import org.testng.annotations.Test;

public class TestFactoryExec {
		
	private Integer testNum;
	
	public TestFactoryExec(Integer testNum) {
		this.testNum = testNum;
	}
	
	@Test
	public void execTest() {
		System.out.println("------------------------------------------");
		System.out.println("Executing the Test '"+testNum+"' create from the TestNGFactory");
		System.out.println("------------------------------------------");
	}
}

