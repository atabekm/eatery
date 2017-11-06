package com.example.eatery.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.eatery.EateryApp;
import com.example.eatery.R;
import com.example.eatery.model.dummy.DummyContent;
import com.example.eatery.network.EateryService;
import com.example.eatery.view.ItemAdapter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ItemListActivity extends AppCompatActivity {

    private boolean twoPane;

    @Inject Context context;
    @Inject EateryService eateryService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        ((EateryApp) getApplication()).getComponent().inject(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true;
        }

        RecyclerView recyclerView = findViewById(R.id.item_list);
        recyclerView.setAdapter(new ItemAdapter(this, DummyContent.ITEMS, twoPane));

        eateryService.getItems()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(items -> Log.d("mytest", "accept: " + items.size()));
    }
}
