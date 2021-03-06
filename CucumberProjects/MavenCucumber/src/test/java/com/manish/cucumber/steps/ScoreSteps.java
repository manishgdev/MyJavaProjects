package com.manish.cucumber.steps;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import java.util.Map;
import org.junit.*;
import com.manish.cucumber.support.Team;
import com.manish.cucumber.helper.TeamHelper;

public class ScoreSteps{
    
    private TeamHelper teamHelper;
    
    public ScoreSteps(TeamHelper teamHelper) {
        this.teamHelper = teamHelper;
    }
    
    @Then("^my score is (\\d+)$")
    public void myScoreIs(int score) throws Throwable {
        Assert.assertEquals("Team Score is not matching : ",teamHelper.getScore(),score); 
    }
    
    @When("^I submit correct answer$")
    public void iSubmitCorrectAnswerThenMyScoreIs() throws Throwable {
        teamHelper.submitCorrectAnswer();
    }
}