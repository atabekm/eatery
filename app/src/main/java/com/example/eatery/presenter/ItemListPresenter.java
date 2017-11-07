package com.example.eatery.presenter;

import com.example.eatery.Mvp;
import com.example.eatery.network.EateryService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by atabek on 11/06/2017.
 */

public class ItemListPresenter implements Mvp.ItemList.Presenter {

    private Mvp.ItemList.View view;
    private EateryService eateryService;

    public ItemListPresenter(EateryService eateryService) {
        this.eateryService = eateryService;
    }

    @Override
    public void setView(Mvp.ItemList.View view) {
        this.view = view;
    }

    @Override
    public void loadItems() {
        view.setLoadingIndicator(true);
        eateryService.getItems()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(items -> {
                view.updateItemList(items);
                view.setLoadingIndicator(false);
            });
    }
}
