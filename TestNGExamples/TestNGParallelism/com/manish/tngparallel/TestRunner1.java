package com.manish.tngparallel;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestRunner1 {
	
	@Test
	public void testMethod1() {
		System.out.println("class => 'TestRunner1' method => 'testMehod1'");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("class => 'TestRunner1' method => 'testMehod2'");
	}
	
	@Test
	public void testMethod3() {
		System.out.println("class => 'TestRunner1' method => 'testMehod3'");
	}
	
	@Test
	public void testMethod4() {
		System.out.println("class => 'TestRunner1' method => 'testMehod4'");
	}
}
