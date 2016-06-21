package com.manish.cucumber.steps;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import java.util.Map;
import org.junit.*;

import com.manish.cucumber.support.Team;

public class ScoreSteps{
    
    @Then("^my score is (\\d+)$")
    public void myScoreIs(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}