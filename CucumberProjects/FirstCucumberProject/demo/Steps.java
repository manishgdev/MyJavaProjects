package demo;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import java.util.Map;
import org.junit.*;
import support.Team;

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
    
    @Given("^the leader board looks like:$")
    public void the_leader_board_looks_like(Map<String, Integer> dataMap) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
    // E,K,V must be a scalar (String, Integer, Date, enum etc)
        System.out.println("Team Score for Pirates is : "+dataMap.get("Pirates"));
        System.out.println("Team Score for Sailors is : "+dataMap.get("Sailors"));
        Assert.assertEquals(20,(long)dataMap.get("Pirates"));
    }


}