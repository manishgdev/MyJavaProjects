package demo;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;

import org.junit.*;

public class Steps {
    Team team;
    
    @Given("^I register a new team \"([^\"]*)\"$")
    public void iRegisterANewTeamm(String teamName) throws Throwable {
        team = new Team();
//        team.setTeamName("Hello");
        team.setTeamName(teamName);
    }

    @Then("^my score is (\\d+)$")
    public void myScoreIs(int score) throws Throwable {
        System.out.println("Team Score is : "+team.getScore());
        Assert.assertEquals(score,team.getScore());
    }
    
    @Then("^Team Name is \"([^\"]*)\"$")
    public void team_Name_is(String teamName) throws Throwable {
        Assert.assertEquals(teamName,team.getTeamName());
    }

}