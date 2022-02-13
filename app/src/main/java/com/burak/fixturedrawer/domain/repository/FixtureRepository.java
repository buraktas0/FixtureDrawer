package com.burak.fixturedrawer.domain.repository;

import com.burak.fixturedrawer.domain.model.Fixture;

import io.reactivex.rxjava3.core.Flowable;

public interface FixtureRepository {

    Flowable<Fixture> getFixture();
}
