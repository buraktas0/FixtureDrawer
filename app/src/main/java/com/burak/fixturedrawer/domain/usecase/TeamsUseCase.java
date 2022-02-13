package com.burak.fixturedrawer.domain.usecase;

import com.burak.fixturedrawer.domain.model.Team;
import com.burak.fixturedrawer.domain.repository.TeamsRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ViewModelScoped;
import io.reactivex.rxjava3.core.Flowable;

public class TeamsUseCase extends BaseUseCase<List<Team>> {

    private final TeamsRepository teamsRepository;

    @Inject
    public TeamsUseCase(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    @Override
    public Flowable<List<Team>> execute() {
        return teamsRepository.getTeams();
    }
}