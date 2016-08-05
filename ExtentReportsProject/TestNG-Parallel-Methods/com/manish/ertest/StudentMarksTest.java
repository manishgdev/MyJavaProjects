package com.manish.ertest;

import org.testng.annotations.*;
import com.manish.beans.Student;
import org.testng.Assert;
import com.manish.base.TestNGBase;
import com.manish.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus; 

public class StudentMarksTest extends TestNGBase {
	
	@Test
	public void studentTrueMarks() {
		Student st = new Student();
		System.out.println("Inside Method :- '"+(Thread.currentThread().getStackTrace()[1].getMethodName())+"' & Thread ID :- " + Thread.currentThread().getId() );
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Set Marks of Student to 60");
		st.setMarks(60);
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Perform Assertion on Marks of Student");
		Assert.assertEquals(st.getMarks(), 60, "Marks not equal :-");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Assertion on Marks of Student : Passed");
	}
	
	@Test
	public void studentGraceTrueMarks() {
		Student st = new Student();
		System.out.println("Inside Method :- '"+(Thread.currentThread().getStackTrace()[1].getMethodName())+"' & Thread ID :- " + Thread.currentThread().getId() );
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Set Marks of Student to 60");
		st.setMarks(60);
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Perform Assertion on Marks of Student");
		Assert.assertEquals(st.getMarks() + 10, 70, "Marks not equal :-");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Assertion on Marks of Student : Passed");
		
	}
	
	@Test
	public void studentFalseMarks() {
		Student st = new Student();
		System.out.println("Inside Method :- '"+(Thread.currentThread().getStackTrace()[1].getMethodName())+"' & Thread ID :- " + Thread.currentThread().getId() );
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Set Marks of Student to 60");
		st.setMarks(60);
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Perform Assertion on Marks of Student");
		Assert.assertEquals(st.getMarks(), st.fixMarks(), "Marks not equal :-");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Assertion on Marks of Student : Passed");
	}
}
