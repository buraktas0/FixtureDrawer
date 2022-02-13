package com.burak.fixturedrawer.data.local;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class LocalModule {

    @Singleton
    @Provides
    public static LocalService provideLocalService(LocalService localService) {
        return new LocalService();
    }
}
