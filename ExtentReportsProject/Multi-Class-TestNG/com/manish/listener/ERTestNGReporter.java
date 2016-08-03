package com.manish.listener;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import org.testng.ITestNGMethod;

import java.io.File;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import java.util.Date;
import java.util.Calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus; 

public class ERTestNGReporter implements IReporter {
	
	private ExtentReports extent;
	private ExtentTest parentTest;
	
	@Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		String folderPath = System.getProperty("user.dir") + File.separator + "extent-reports";
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String fileName = folderPath + File.separator + "Report-" + df.format(new Date()) + ".html";
		extent = new ExtentReports(fileName, false);
		extent.loadConfig(new  File(folderPath + File.separator +".."+ File.separator +"extent-config.xml"));
		
		for(ISuite suite : suites) {
			Map<String, ISuiteResult> suiteMap = suite.getResults();
			
			for(ISuiteResult suiteResult : suiteMap.values()) {
				
				ITestContext testContext = suiteResult.getTestContext();
				String parentName = testContext.getName();
				
				// create parent test object here
				parentTest = extent.startTest(parentName);
				
				// do processing for child test objects here
				List<ExtentTest> childTestList = childTestList(testContext);
				childTestList(testContext);
				
				// add the child test objects to parent test object
				for(ExtentTest childTest : childTestList) {
					parentTest.appendChild(childTest);
				}
				extent.endTest(parentTest);
				extent.flush();
				
			}
		}
		
		extent.close();
        
	}
	
	private List<ExtentTest> childTestList(ITestContext testContext) {
		List<ExtentTest> childTestList = new ArrayList<ExtentTest>();
		
		childTestList.addAll(childTestListFromResultMap(testContext.getPassedTests(), LogStatus.PASS));
		childTestList.addAll(childTestListFromResultMap(testContext.getFailedTests(), LogStatus.FAIL));
		childTestList.addAll(childTestListFromResultMap(testContext.getSkippedTests(), LogStatus.SKIP));
		
		return childTestList;
	}
	
	private List<ExtentTest> childTestListFromResultMap(IResultMap resultMap, LogStatus status) {
		List<ExtentTest> childTestList = new ArrayList<ExtentTest>();
		
		for(ITestResult testResult : resultMap.getAllResults()) {
			ITestNGMethod testMethod = testResult.getMethod();
			String methodName = testMethod.getMethodName();
			ExtentTest childTest = extent.startTest(methodName);
			
			// Assign categories to the Test
			for(String groupName : testMethod.getGroups()) {
				System.out.println("Category Found :- " + groupName);
				childTest.assignCategory(groupName);
			}
			
			// get starttime and end time of test
			childTest.setStartedTime(getTime(testResult.getStartMillis()));
			childTest.setEndedTime(getTime(testResult.getStartMillis()));
			
			// Add Logs for the Test
			if(testResult.getThrowable() != null) {
				childTest.log(status, testResult	.getThrowable());
			}
			else {
				childTest.log(status, methodName + " "+ status.toString().toLowerCase()+"ed");
			}
			
			extent.endTest(childTest);
			childTestList.add(childTest);
		}
		
		return childTestList;
	}
	
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
