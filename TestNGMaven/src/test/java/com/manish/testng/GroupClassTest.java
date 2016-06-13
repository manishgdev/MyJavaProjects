package com.manish.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.lang.reflect.Method;
import org.testng.ITestResult;
import java.util.List;
import java.util.Arrays;

/**
*  @author : Manish Singh
*   Creating this class to run from Maven Command
*/
public class GroupClassTest {
    
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method m) {
        System.out.println("==========================");
        System.out.println("Going to start execution of Method : '"+m.getName()+"'");
    }
    
    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        System.out.println("Execution of Method : '"+result.getMethod().getMethodName()+"' completed");
        List<String> groupList= Arrays.asList(result.getMethod().getGroups());
        System.out.println("Method = '"+result.getMethod().getMethodName()+"' belongs to these groups : "+groupList);
        System.out.println("===========================");
    }
    
    @Test(groups={"runGroup"})
    public void groupTestMethod1() {
        System.out.println("Executing Test Method1");
    }
    
    @Test(groups={"willRun"})
    public void groupTestMethod2() {
        System.out.println("Executing Test Method2");
    }
    
    @Test(groups={"excludeRun"})
    public void groupTestMethod3() {
        System.out.println("Executing Test Method3");
    }
    
    @Test(groups={"runGroup","willRun"})
    public void groupTestMethod4() {
        System.out.println("Executing Test Method4");
    }
    
    @Test(groups={"runGroup","excludeRun"})
    public void groupTestMethod5() {
        System.out.println("Executing Test Method5");
    }
}
