package com.manish.cucumber.steps;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import java.util.Map;
import org.testng.Assert;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.Scenario;

public class HooksSteps {
    
    @After
    public void afterAnnotation(Scenario scenario) {
        System.out.println("--After Hook for Scenario with No Hook + Scenario = '"+scenario.getName()+"'");
    }
    
    @Before
    public void beforeAnnotation() {
        System.out.println("--Executing Before Hook for Scenario with No Hook");
    }
    
    @After("@Hook1")
    public void afterHook1Annotation(Scenario scenario) {
        System.out.println("##After Hook for Scenario with '@Hook1' tag + Scenario = '"+scenario.getName()+"'");
    }
    
    @Before("@Hook1")
    public void beforeHook1Annotation() {
        System.out.println("##Executing Before Hook for Scenario with '@Hook1' tag");
    }
    
    @After("@Hook2")
    public void afterHook2Annotation(Scenario scenario) {
        System.out.println("**After Hook for Scenario with '@Hook2' tag + Scenario = '"+scenario.getName()+"'");
    }
    
    @Before("@Hook2")
    public void beforeHook2Annotation() {
        System.out.println("**Executing Before Hook for Scenario with '@Hook2' tag");
    }
    
    @After("@Hook1,@Hook2")
    public void afterHook1Hook2Annotation(Scenario scenario) {
        System.out.println("**##After Hook for Scenario with '@Hook1,@Hook2' tag + Scenario = '"+scenario.getName()+"'");
    }
    
    @Before("@Hook1,@Hook2")
    public void beforeHook1Hook2Annotation() {
        System.out.println("**##Execution of Before Hook for Scenario with '@Hook1,@Hook2' tag");
    }
    
    @Given("^This is simple method \"([^\"]*)\"$")
    public void thisIsSimpleMethod(String hookName) throws Throwable {
        System.out.println("========> Executing the Step Definition with Hook = "+hookName);
    }
}
