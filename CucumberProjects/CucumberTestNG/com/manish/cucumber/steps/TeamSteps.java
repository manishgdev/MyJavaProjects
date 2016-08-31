package com.manish.cucumber.steps;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import java.util.Map;
import org.testng.Assert;
import com.manish.cucumber.support.Team;
import com.manish.cucumber.helper.TeamHelper;

public class TeamSteps{
    
    private TeamHelper teamHelper;
    
    public TeamSteps(TeamHelper teamHelper) {
        this.teamHelper = teamHelper;
    }
    
    @Given("^I register a new team \"([^\"]*)\"$")
    public void iRegisterANewTeam(String teamName) throws Throwable {
        teamHelper.registerTeam(teamName);
    }

    @Then("^Team Name is \"([^\"]*)\"$")
    public void teamNameIs(String teamName) throws Throwable {
        Assert.assertEquals(teamHelper.getTeamName(),teamName, "Team Name is not matching : ");
    }
}    
