package com.manish.ertest;

import org.testng.annotations.*;
import org.testng.ITestResult;
import java.lang.reflect.Method;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleTestNGClass {
	
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeClass
	public void beforeClass() {
		String folderPath = System.getProperty("user.dir") + File.separator + "extent-reports";
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String fileName = folderPath + File.separator + "Report-" + df.format(new Date()) + ".html";
		extent = new ExtentReports(fileName, false);
		extent.addSystemInfo("Environment", "Testing Extent Report");
		
		extent.loadConfig(new  File(folderPath + File.separator +".."+ File.separator +"extent-config.xml"));
	}
	
	@BeforeMethod
	public void beforeMethod(Method m) {
		String methodName = m.getName();
		test = extent.startTest(methodName);
		test.log(LogStatus.INFO, methodName + " started");
		
		Pattern p = Pattern.compile("^.*(\\d)$");
		Matcher mtch = p.matcher(methodName);
		String lastNum = "0";
		if(mtch.find()) {
			lastNum = mtch.group(1);
		}
		
		Integer methodNum = Integer.parseInt(lastNum);
		
		if(methodNum < 3) {
			test.assignCategory("Category 1");
			test.assignAuthor("Manish Singh");
		}
		else if(methodNum >= 3 && methodNum < 6) {
			test.assignCategory("Category 2");
			test.assignAuthor("Roshan Singh");
		}
		else {
			test.assignCategory("Category 3");
			test.assignAuthor("Manish Singh", "Roshan Singh");
		}
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + " finished");
		
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getMethod().getMethodName() + " passed");
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(LogStatus.SKIP, result.getThrowable());
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test
	public void method1() {
		Assert.assertEquals(2, 5, "The values are not equal");
	}
	
	@Test
	public void method2() {
		Assert.assertEquals(5, 5, "The values are not equal");
	}
	
	@Test
	public void method3() {
		Assert.assertEquals(5, 5, "The values are not equal");
	}
	
	@Test
	public void method4() {
		Assert.assertEquals(4, 5, "The values are not equal");
	}
	
	@Test
	public void method5() {
		Assert.assertEquals(5, 5, "The values are not equal");
	}
	
	@Test
	public void method6() {
		Assert.assertEquals(5, 5, "The values are not equal");
	}
	
	@Test
	public void method7() {
		throw new RuntimeException("Checking Types of Exception caught by Extent Report");
	}
	
	@AfterClass
	public void afterClass() {
		extent.close();
	}
}
