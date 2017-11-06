package com.example.eatery.network;

import com.example.eatery.model.Item;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by atabek on 11/06/2017.
 */

public interface EateryService {

    @GET("bins/b7jwr")
    Observable<List<Item>> getItems();

}
