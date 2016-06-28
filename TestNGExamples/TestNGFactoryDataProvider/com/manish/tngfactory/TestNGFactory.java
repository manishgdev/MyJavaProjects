package com.manish.tngfactory;

import org.testng.annotations.Factory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.ITestResult;
import java.util.List;
import java.util.ArrayList;

public class TestNGFactory {
	private int param;
 
    @Factory(dataProvider = "dataMethod")
    public TestNGFactory(int param) {
        this.param = param;
    }
 
    @DataProvider
    public static Object[][] dataMethod() {
        return new Object[][] {
			 new Object[]{1},
			 new Object[]{3} 
		};
    }
 
    @Test
    public void testMethodOne() {
        int opValue = param + 1;
        System.out.println("Test method one output: " + opValue);
    }
 
    //@Test
    public void testMethodTwo() {
        int opValue = param + 2;
        System.out.println("Test method two output: " + opValue);
    }

}


