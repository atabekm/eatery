package com.example.eatery.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eatery.R;
import com.example.eatery.model.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atabek on 11/06/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> values = new ArrayList<>();
    private View.OnClickListener onClickListener;

    public ItemAdapter(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Item item = values.get(position);

        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());

        if (item.getImageUrl() != null) {
            holder.icon.setVisibility(View.VISIBLE);
            Picasso
                .with(holder.name.getContext())
                .load(item.getImageUrl())
                .resize(70 * 3, 70 * 3)
                .centerCrop()
                .into(holder.icon);
        }

        holder.itemView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public void updateData(List<Item> data) {
        values = data;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;
        ImageView icon;

        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            description = view.findViewById(R.id.description);
            icon = view.findViewById(R.id.icon);
        }
    }
}
