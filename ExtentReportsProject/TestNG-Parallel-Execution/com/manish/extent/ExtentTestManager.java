package com.manish.extent;

import java.util.Map;
import java.util.HashMap;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus; 

public class ExtentTestManager {
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    static ExtentReports extent = ExtentManager.getReporter();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((Integer) (int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest() {
        extent.endTest(extentTestMap.get((Integer) (int) (long) (Thread.currentThread().getId())));
    }

    public static synchronized ExtentTest startTest(String testName) {
        // return startTest(testName,(int) (long) (Thread.currentThread().getId())+ "");
        return startTest(testName,"Test Case : '"+testName + "' started on Thread Id :- " + (Integer) (int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((Integer) (int) (long) (Thread.currentThread().getId()), test);

        return test;
    }
	
	public static synchronized void close() {
        extent.close();
    }
}
