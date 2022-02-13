package com.burak.fixturedrawer.data.local;

import com.burak.fixturedrawer.domain.model.Fixture;
import com.burak.fixturedrawer.domain.model.Matchup;
import com.burak.fixturedrawer.domain.model.Team;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public class LocalService {

    public Flowable<Fixture> getFixture(List<Team> teamList) {
        return Flowable.just(generateFixture(teamList));
    }

    private Fixture generateFixture(List<Team> teamList) {
        List<Matchup> matchupList = generateFirstHalf(teamList);
        List<Matchup> secondHalfMatchupList = generateSecondHalf(matchupList);
        matchupList.addAll(secondHalfMatchupList);
        return new Fixture(matchupList, (teamList.size() - 1) * 2);
    }

    private List<Matchup> generateFirstHalf(List<Team> teamList) {
        List<Team> teams = new ArrayList<>(teamList);

        int remainder = teams.size() % 2;
        if (remainder == 1) teams.add(new Team(-1, "Bye", ""));

        int weekCount = teams.size() - 1;
        int weeklyMatchupCount = (teams.size() / 2);

        List<Matchup> matchupList = new ArrayList<>();
        List<Team> tempTeamList = new ArrayList<>();

        for (int i = 0; i < weekCount; i++) {
            for (int j = 0; j < weeklyMatchupCount; j++) {
                Matchup matchup = new Matchup(teams.get(j), teams.get(teams.size() - 1 - j), i + 1);
                if (matchup.homeTeam.id != -1 && matchup.awayTeam.id != -1)
                    matchupList.add(matchup);
            }

            tempTeamList = new ArrayList<>();
            tempTeamList.add(teams.get(0));
            tempTeamList.add(teams.get(teams.size() - 1));

            for (int k = 1; k < teams.size() - 1; k++) {
                tempTeamList.add(teams.get(k));
            }

            teams = tempTeamList;

        }

        return matchupList;
    }

    private List<Matchup> generateSecondHalf(List<Matchup> firstHalfMatchupList) {
        //TODO check
        List<Matchup> matchupList = new ArrayList<>();
        int lastWeek = firstHalfMatchupList.get(firstHalfMatchupList.size() - 1).week;
        for (Matchup matchup : firstHalfMatchupList) {
            matchupList.add(new Matchup(matchup.awayTeam, matchup.homeTeam, matchup.week + lastWeek));
        }

        return matchupList;
    }

}
