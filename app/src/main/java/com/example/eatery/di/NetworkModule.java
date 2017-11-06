package com.example.eatery.di;

import com.example.eatery.network.EateryService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by atabek on 11/06/2017.
 */

@Module
public class NetworkModule {

    @Singleton
    @Provides
    GsonConverterFactory providesGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    RxJava2CallAdapterFactory providesRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Singleton
    @Provides
    Retrofit providesRetrofit(GsonConverterFactory converterFactory, RxJava2CallAdapterFactory adapterFactory) {
        return new Retrofit.Builder()
            .baseUrl("https://api.myjson.com")
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .build();
    }

    @Singleton
    @Provides
    EateryService providesEateryService(Retrofit retrofit) {
        return retrofit.create(EateryService.class);
    }
}
