package com.burak.fixturedrawer.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Fixture {

    public List<Matchup> matchupList;
    public int weekCount;

    public Fixture(List<Matchup> matchupList, int weekCount) {
        this.matchupList = matchupList;
        this.weekCount = weekCount;
    }

    public List<Matchup> getWeeklyFixture(int week) {
        List<Matchup> weeklyMatchupList = new ArrayList<>();
        for (Matchup matchup : matchupList) {
            if (matchup.week == week) weeklyMatchupList.add(matchup);
        }
        return weeklyMatchupList;
    }
}
