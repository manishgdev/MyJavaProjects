package com.manish.cucumber.steps;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import java.util.Map;
import org.junit.*;
import com.manish.cucumber.support.Team;

public class TeamSteps{
    
    @Given("^I register a new team \"([^\"]*)\"$")
    public void iRegisterANewTeam(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Team Name is \"([^\"]*)\"$")
    public void teamNameIs(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}    