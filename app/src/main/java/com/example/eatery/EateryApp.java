package com.example.eatery;

import android.app.Application;

import com.example.eatery.di.AppComponent;
import com.example.eatery.di.AppModule;
import com.example.eatery.di.DaggerAppComponent;

/**
 * Created by atabek on 11/06/2017.
 */

public class EateryApp extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent
            .builder()
            .appModule(new AppModule(this))
            .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
