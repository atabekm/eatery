package com.example.eatery.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by atabek on 11/06/2017.
 */

public class Item implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("rating")
    private Integer rating;

    @SerializedName("average_price")
    private Double averagePrice;

    @SerializedName("image_url")
    private String imageUrl;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getRating() {
        return rating;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
