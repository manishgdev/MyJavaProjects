package com.fs.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.fs.columns.Columns;
import com.fs.excel.ExcelWriter;

public class TestNGTestClass {

	ExcelWriter excelWriter = new ExcelWriter(System.getProperty("user.dir"), "testOut" + new SimpleDateFormat("hhmmss").format(new Date()) + ".xlsx");

	@BeforeMethod
	public void beforeMethod() {

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

		String resultString = "";
		if (result.getStatus() == ITestResult.SUCCESS)
			resultString = "PASSED";
		else if (result.getStatus() == ITestResult.FAILURE)
			resultString = "FAILED";
		System.out.println("Result String : " + resultString);
		System.out.println("Test Case Name : " + result.getName());
		Date startDate = new Date(result.getStartMillis());
		Date endDate = new Date(result.getEndMillis());
		Throwable t = result.getThrowable();
		HashMap<Columns, String> rowContent = new HashMap<Columns, String>();
		rowContent.put(Columns.TESTCASENAME, result.getName());
		rowContent.put(Columns.TESTRESULT, resultString);
		rowContent.put(Columns.TESTSTARTTIME, startDate.toString());
		rowContent.put(Columns.TESTLOG, getResultAttribute(result));
		rowContent.put(Columns.TESTENDTIME, endDate.toString());
		rowContent.put(Columns.TESTERRORMESSAGE, getStackTraceString(t));
		rowContent.put(Columns.TESTCASEDESCRIPTION, result.getMethod().getDescription());
		excelWriter.writeToExcel(rowContent);
	}

	@Test(description = "Dummy Text for Method A")
	public void testMethodA() {

		System.out.println(Columns.TESTCASENAME.toString());
		try
		{
			Thread.sleep(1000);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("Executed Test Method A");
	}

	@Test(description = "Dummy Text for Method B")
	public void testMethodB() {

		System.out.println(Columns.TESTCASENAME.toString());
		try
		{
			Thread.sleep(1000);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("Executed Test Method B");
	}

	@Test(description = "Dummy Text for Method B")
	public void testMethodC() throws Exception {

		ITestResult result = Reporter.getCurrentTestResult();
		System.out.println(Columns.TESTCASENAME.toString());
		result.setAttribute("Test", "Hello");
		try
		{
			result.setAttribute("Test 2", "Inside Try Catch");
			Thread.sleep(2000);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		result.setAttribute("Test 3", "Outside Try Catch");
		System.out.println("Executed Test Method C");
		throw new Exception("Throwing Custom Message to Detect Throwable Class");
	}

	@AfterTest
	public void afterTest() throws IOException {

		excelWriter.closeWorkbook();
	}

	@BeforeTest
	public void beforeTest() throws IOException {

		excelWriter.createExcelFile();
		excelWriter.createSheet("output");
		excelWriter.selectSheet(0);
	}

	public String getResultAttribute(ITestResult result) {

		String tempString = "";
		List<String> attributeList = new ArrayList<String>(result.getAttributeNames());
		for (int i = 0; i < attributeList.size(); i++)
			tempString += (i + 1) + " : " + attributeList.get(i) + " = " + result.getAttribute(attributeList.get(i)) + "\n";
		return tempString;
	}

	public String getStackTraceString(Throwable throwObj) {

		String stackTraceMessage = "";
		if (throwObj != null)
		{
			if (throwObj.getStackTrace() != null)
			{
				List<StackTraceElement> stackElementList = Arrays.asList(throwObj.getStackTrace());
				for (int i = 0; i < stackElementList.size(); i++)
				{
					stackTraceMessage += (i + 1) + " : Class Name => " + stackElementList.get(i).getClassName() + " , Method Name => " + stackElementList.get(i).getMethodName() + " , Line Number => "
							+ stackElementList.get(i).getLineNumber() + "\n";
				}
			}
		}
		return stackTraceMessage;
	}
}
