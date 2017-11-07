package com.example.eatery.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.eatery.R;
import com.example.eatery.model.Item;
import com.squareup.picasso.Picasso;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemDetailFragment extends Fragment {
    public static final String ARG_ITEM = "item";
    private Item item;

    @BindView(R.id.item_name) TextView name;
    @BindView(R.id.item_description) TextView description;
    @BindView(R.id.item_average_price) TextView averagePrice;
    @BindView(R.id.item_rating) RatingBar ratingBar;
    @BindView(R.id.item_icon) ImageView icon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM)) {
            item = (Item) getArguments().getSerializable(ARG_ITEM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);
        ButterKnife.bind(this, rootView);

        if (item != null) {
            name.setText(item.getName());
            description.setText(item.getDescription());
            averagePrice.setText(String.format(Locale.getDefault(),"$%.2f", item.getAveragePrice()));
            ratingBar.setRating(item.getRating());
            ratingBar.setIsIndicator(true);
            Picasso.with(rootView.getContext())
                .load(item.getImageUrl())
                .into(icon);
        }

        return rootView;
    }
}
