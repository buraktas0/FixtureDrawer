package com.burak.fixturedrawer.data.repository;

import com.burak.fixturedrawer.data.api.ApiService;
import com.burak.fixturedrawer.data.local.LocalService;
import com.burak.fixturedrawer.domain.model.Fixture;
import com.burak.fixturedrawer.domain.model.Team;
import com.burak.fixturedrawer.domain.repository.FixtureRepository;

import org.reactivestreams.Publisher;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;

public class FixtureDataRepository implements FixtureRepository {

    private final LocalService localService;
    private final ApiService apiService;

    @Inject
    public FixtureDataRepository(LocalService localService, ApiService apiService) {
        this.localService = localService;
        this.apiService = apiService;
    }

    @Override
    public Flowable<Fixture> getFixture() {
        return apiService.getTeams().flatMap(new Function<List<Team>, Publisher<Fixture>>() {
            @Override
            public Publisher<Fixture> apply(List<Team> teamList) throws Throwable {
                return localService.getFixture(teamList);
            }
        });
    }
}
