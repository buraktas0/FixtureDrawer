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
        List<Matchup> matchupList = new ArrayList<>();


        //TODO fixture algorithm

        return new Fixture(matchupList, teamList.size() - 1);
    }


}
