package com.example.eatery.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.eatery.EateryApp;
import com.example.eatery.Mvp;
import com.example.eatery.R;
import com.example.eatery.model.Item;
import com.example.eatery.presenter.ItemListPresenter;
import com.example.eatery.view.ItemAdapter;
import com.example.eatery.view.fragment.ItemDetailFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemListActivity extends AppCompatActivity implements Mvp.ItemList.View {

    private boolean twoPane;
    private ItemAdapter itemAdapter;

    @Inject ItemListPresenter presenter;

    @BindView(R.id.item_list) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        ButterKnife.bind(this);

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

        itemAdapter = new ItemAdapter(itemClickListener);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        presenter.setView(this);
        presenter.loadItems();
    }

    @Override
    public void updateItemList(List<Item> itemList) {
        itemAdapter.updateData(itemList);
    }

    private ItemClickListener itemClickListener = new ItemClickListener() {
        @Override
        public void onItemClick(Item item) {
            if (twoPane) {
                Bundle arguments = new Bundle();
                arguments.putSerializable(ItemDetailFragment.ARG_ITEM, item);
                ItemDetailFragment fragment = new ItemDetailFragment();
                fragment.setArguments(arguments);
                getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();
            } else {
                Intent intent = new Intent(ItemListActivity.this, ItemDetailActivity.class);
                intent.putExtra(ItemDetailFragment.ARG_ITEM, item);
                startActivity(intent);
            }
        }
    };

    public interface ItemClickListener {
        void onItemClick(Item item);
    }
}
