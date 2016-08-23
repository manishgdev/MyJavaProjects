package com.manish.testNGXML;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.Assert;

//@Test
//@Parameters({"filepath","filename","sheetname"})
public class TestExecuteXML {
	
	@Test
	@Parameters({"filepath","filename","sheetname"})
	public void testMethod(String FileName, String FilePath, String SheetName) {
		System.out.println("Executing Test Method from com.manish.testNGXML package");
		
		System.out.println("File Name : "+FileName);
		System.out.println("File Path : "+FilePath);
		System.out.println("SheetName : "+SheetName);
		Assert.assertEquals(true,false);
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod(ITestResult result) {
		System.out.println("Inside After Method");
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Test Failed with some error");
		}
	}
}
