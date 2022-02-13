package com.burak.fixturedrawer.data.repository;

import com.burak.fixturedrawer.data.api.ApiService;
import com.burak.fixturedrawer.data.local.LocalService;
import com.burak.fixturedrawer.domain.repository.FixtureRepository;
import com.burak.fixturedrawer.domain.repository.TeamsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Singleton
    @Provides
    public static TeamsRepository provideTeamsRepository(ApiService apiService) {
        return new TeamsDataRepository(apiService);
    }

    @Singleton
    @Provides
    public static FixtureRepository provideFixtureRepository(LocalService localService, ApiService apiService) {
        return new FixtureDataRepository(localService,apiService);
    }
}
