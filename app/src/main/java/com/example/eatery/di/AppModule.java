package com.example.eatery.di;

import android.app.Application;
import android.content.Context;

import com.example.eatery.network.EateryService;
import com.example.eatery.presenter.ItemListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by atabek on 11/06/2017.
 */

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Context providesApplicationContext() {
        return application.getApplicationContext();
    }

    @Provides
    ItemListPresenter providesItemListPresenter(EateryService eateryService) {
        return new ItemListPresenter(eateryService);
    }
}
