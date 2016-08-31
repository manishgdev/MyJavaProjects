package com.manish.cucumber.helper;

import com.manish.cucumber.support.Team;

public class TeamHelper {
    
    private Team team;
    
    public void registerTeam(String name) {
        team = new Team(name);    
    }
    
    public String getTeamName() {
        return team.getTeamName();
    }
    
    public int getScore() {
        return team.getScore();
    }
    
    public void submitCorrectAnswer() {
        team.addScore(5);
    }
}