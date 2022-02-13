package com.burak.fixturedrawer.domain.usecase;

import com.burak.fixturedrawer.domain.model.Fixture;
import com.burak.fixturedrawer.domain.model.Team;
import com.burak.fixturedrawer.domain.repository.FixtureRepository;
import com.burak.fixturedrawer.domain.repository.TeamsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

public class FixtureUseCase extends BaseUseCase<Fixture> {

    private final FixtureRepository fixtureRepository;

    @Inject
    public FixtureUseCase(FixtureRepository fixtureRepository) {
        this.fixtureRepository = fixtureRepository;
    }

    @Override
    public Flowable<Fixture> execute() {
        return fixtureRepository.getFixture();
    }
}