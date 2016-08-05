package com.manish.ertest;

import org.testng.annotations.*;
import com.manish.beans.Animal;
import org.testng.Assert;
import com.manish.base.TestNGBase;
import com.manish.extent.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus; 

public class AnimalLegsTest extends TestNGBase{
	
	@Test(groups = {"G1", "G2"})
	public void animalTrueLegs() {
		Animal an = new Animal();
		System.out.println("Inside Method :- '"+(Thread.currentThread().getStackTrace()[1].getMethodName())+"' & Thread ID :- " + Thread.currentThread().getId() );
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Set Number of Legs to 4");
		an.setNumLegs(4);
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Perform Assertion on number of Legs");
		Assert.assertEquals(an.getNumLegs(), 4, "Legs are not equal :-");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Assertion on number of Legs : Passed");
	}
	
	@Test(groups = {"G2"})
	public void animalLegsModify() {
		Animal an = new Animal();
		System.out.println("Inside Method :- '"+(Thread.currentThread().getStackTrace()[1].getMethodName())+"' & Thread ID :- " + Thread.currentThread().getId() );
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Set Number of Legs to 4");
		an.setNumLegs(4);
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Perform Assertion on number of Legs");
		Assert.assertEquals(an.getNumLegs() + 5, 4+5, "Legs are not equal :-");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Assertion on number of Legs : Passed");
	}
	
	@Test(groups = {"G2", "G3"})
	public void animalFalseLegs() {
		Animal an = new Animal();
		System.out.println("Inside Method :- '"+(Thread.currentThread().getStackTrace()[1].getMethodName())+"' & Thread ID :- " + Thread.currentThread().getId() );
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Set Number of Legs to 4");
		an.setNumLegs(4);
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Perform Assertion on number of Legs");
		Assert.assertEquals(an.getNumLegs(), an.fixLegs(), "Legs are not equal :-");
		ExtentTestManager.getTest().log(LogStatus.INFO, "ThreadId: " + Thread.currentThread().getId(), "Assertion on number of Legs : Passed");
	}
	
}
