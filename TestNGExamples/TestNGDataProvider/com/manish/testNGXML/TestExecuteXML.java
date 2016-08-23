package com.manish.testNGXML;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.Assert;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

//@Test
//@Parameters({"filepath","filename","sheetname"})
public class TestExecuteXML {
	
	@DataProvider(name = "credentialsProvider")
	public Iterator<String[]> testProvider() {
		List<String[]> tmp = new ArrayList<>();
		
		tmp.add(new String[] {"Manish"});
		tmp.add(new String[] {"Piyush"});
		tmp.add(new String[] {"Pratish"});
		tmp.add(new String[] {"Satish"});
		
		return tmp.iterator();
	}
	
	@Test(dataProvider = "credentialsProvider")
	public void testMethod(String userName) {
		System.out.println("Executing Test Method from com.manish.testNGXML package");
		
		System.out.println("User Name : "+ userName);
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod(ITestResult result) {
		System.out.println("Inside After Method");
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Test Failed with some error");
		}
	}
}
