package com.manish.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.lang.reflect.Method;
import org.testng.ITestResult;

/**
*  @author : Manish Singh
*   Creating this class to run from Maven Command
*/
public class AppTest {
    
    @BeforeMethod
    public void beforeMethod(Method m) {
        System.out.println("==========================");
        System.out.println("Going to start execution of Method : '"+m.getName()+"'");
    }
    
    @AfterMethod
    public void afterMethod(ITestResult result) {
        System.out.println("Execution of Method : '"+result.getMethod().getMethodName()+"' completed");
        System.out.println("===========================");
    }
    
    @Test
    public void firstMethod() {
        System.out.println("Executing First Method");
    }
    
    @Test
    public void secondMethod() {
        System.out.println("Executing Second Method");
    }
}
