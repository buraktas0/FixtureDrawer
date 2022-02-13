package com.burak.fixturedrawer.data.api;

import com.burak.fixturedrawer.domain.model.Team;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("teams")
    Flowable<List<Team>> getTeams();
}
