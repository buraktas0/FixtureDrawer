package com.burak.fixturedrawer.domain.usecase;

import io.reactivex.rxjava3.core.Flowable;

public abstract class BaseUseCase<Response> {

    public abstract Flowable<Response> execute();

}