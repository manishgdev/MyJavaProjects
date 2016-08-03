package com.manish.ertest;

import org.testng.annotations.*;
import com.manish.beans.Animal;
import org.testng.Assert;
import com.manish.base.TestNGBase;
import com.manish.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus; 

public class AnimalNameTest extends TestNGBase{
	
	@Test
	public void animalTrueName() {
		Animal an = new Animal();
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Set Name of Animal to Lion");
		an.setName("Lion");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Perform Assertion on name of Animal");
		Assert.assertEquals(an.getName(), "Lion", "Names are not equal :-");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Assertion on name of Animal : Passed");
	}
	
	@Test
	public void animalNameModify() {
		Animal an = new Animal();
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Set Name of Animal to Lion");
		an.setName("Lion");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Perform Assertion on name of Animal");
		Assert.assertEquals(an.getName() + " ", "Lion ", "Names are not equal :-");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Assertion on name of Animal : Passed");
	}
}
