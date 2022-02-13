package com.burak.fixturedrawer.data.repository;

import com.burak.fixturedrawer.data.api.ApiService;
import com.burak.fixturedrawer.domain.model.Team;
import com.burak.fixturedrawer.domain.repository.TeamsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

public class TeamsDataRepository implements TeamsRepository {

    private final ApiService apiService;

    @Inject
    public TeamsDataRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Flowable<List<Team>> getTeams() {
        return apiService.getTeams();
    }
}
