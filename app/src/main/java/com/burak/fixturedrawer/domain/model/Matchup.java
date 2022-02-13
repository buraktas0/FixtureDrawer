package com.burak.fixturedrawer.domain.model;

public class Matchup {
    public Team homeTeam, awayTeam;
    public int week;

    public Matchup(Team homeTeam, Team awayTeam, int week) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.week = week;
    }
}
