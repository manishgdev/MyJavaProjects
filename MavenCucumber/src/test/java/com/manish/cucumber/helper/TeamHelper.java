package com.manish.cucumber.helper;

import com.manish.cucumber.support.Team;

public class TeamHelper {
    
    private Team team;
    
    public void registerTeam(String name) {
        team = new Team();    
    }
    
    public int getScore() {
        return team.getScore();
    }
}