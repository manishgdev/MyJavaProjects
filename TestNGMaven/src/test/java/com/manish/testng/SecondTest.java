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
public class SecondTest {
    
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
    public void testMethod1() {
        System.out.println("Executing Test Method1");
    }
    
    @Test
    public void testMethod2() {
        System.out.println("Executing Test Method2");
    }
    
    @Test
    public void testMethod3() {
        System.out.println("Executing Test Method3");
    }
    
    @Test
    public void testMethod4() {
        System.out.println("Executing Test Method4");
    }
    
    @Test
    public void testMethod5() {
        System.out.println("Executing Test Method5");
    }
}
