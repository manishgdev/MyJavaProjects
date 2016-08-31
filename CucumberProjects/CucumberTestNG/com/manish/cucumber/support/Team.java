package com.manish.cucumber.support;


public class Team {
    
    private int score;
    private String teamName;
    
    public Team() {
        score = 0;
    }
    
    public Team(String teamName) {
        this.teamName = teamName;
        score = 0;
    }
    
    public int getScore() {
        return score;
    }
    
    public String getTeamName() {
        return teamName;
    }
    
    public void addScore(int points) {
        score += points;
    }
}