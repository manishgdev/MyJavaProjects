package com.manish.tngparallel;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestContext;
import org.testng.ITestResult;
import java.lang.reflect.Method;


public class ThreadLocalTest {
	
	ThreadLocal<String> strThreadLocal = new ThreadLocal<>();
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		System.out.println("Inside Before Method, setting ThreadLocal Variable value to :- "+method.getName());
		strThreadLocal.set(method.getName());
	}
	
	@AfterMethod
	public void afterMethod(Method result) {
		System.out.println("Inside After Method, ThreadLocal Variable Value :- "+strThreadLocal.get());
	}
	
	@Test
	public void testMethod1() {
		System.out.println("Inside method => 'testMehod1', ThreadLocal Variable Value :- "+strThreadLocal.get());
	}
	
	@Test
	public void testMethod2() {
		System.out.println("Inside method => 'testMehod2', ThreadLocal Variable Value :- "+strThreadLocal.get());
	}
	
	@Test
	public void testMethod3() {
		System.out.println("Inside method => 'testMehod3', ThreadLocal Variable Value :- "+strThreadLocal.get());
	}
	
	@Test
	public void testMethod4() {
		System.out.println("Inside method => 'testMehod4', ThreadLocal Variable Value :- "+strThreadLocal.get());
	}
}
