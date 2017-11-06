package com.example.eatery.di;

import com.example.eatery.view.activity.ItemListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by atabek on 11/06/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(ItemListActivity activity);
}
