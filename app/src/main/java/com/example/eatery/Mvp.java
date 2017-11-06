package com.example.eatery;

import com.example.eatery.model.Item;

import java.util.List;

/**
 * Created by atabek on 11/06/2017.
 */

public interface Mvp {

    interface ItemList {

        interface View {
            void updateItemList(List<Item> itemList);
        }

        interface Presenter {
            void setView(View view);
            void loadItems();
        }

    }

}
