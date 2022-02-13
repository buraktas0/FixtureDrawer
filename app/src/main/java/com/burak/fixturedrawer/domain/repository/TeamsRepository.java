package com.burak.fixturedrawer.domain.repository;

import com.burak.fixturedrawer.domain.model.Team;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public interface TeamsRepository {

    Flowable<List<Team>> getTeams();
}
