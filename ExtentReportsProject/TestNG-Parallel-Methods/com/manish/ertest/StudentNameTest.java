package com.manish.ertest;

import org.testng.annotations.*;
import com.manish.beans.Student;
import org.testng.Assert;
import com.manish.base.TestNGBase;
import com.manish.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus; 

public class StudentNameTest extends TestNGBase {
	
	@Test
	public void studentTrueName() {
		Student st = new Student();
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Set Name of Student to Manish");
		st.setName("Manish");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Perform Assertion on Name of Student");
		Assert.assertEquals(st.getName(), "Manish", "Names are not equal :-");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Assertion on Name of Student : Passed");
	}
	
	@Test
	public void studentFalseName() {
		Student st = new Student();
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Set Name of Student to Manish");
		st.setName("Manish");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Perform Assertion on Name of Student");
		Assert.assertEquals(st.getName(), st.falseName(), "Names are not equal :-");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Assertion on Name of Student : Passed");
	}
	
	@Test
	public void studentHardFalse() {
		Student st = new Student();
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Set Name of Student to Manish");
		st.setName("Manish");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Perform Assertion on Name of Student");
		Assert.assertEquals(st.getName(), "Rahul", "Names are not equal :-");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Assertion on Name of Student : Passed");
	}
	
	@Test
	public void studentHardTrue() {
		Student st = new Student();
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Set Name of Student to Manish");
		st.setName("Manish");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Perform Assertion on Name of Student");
		Assert.assertEquals(st.getName()+" ", "Manish ", "Names are not equal :-");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Assertion on Name of Student : Passed");
	}
}
