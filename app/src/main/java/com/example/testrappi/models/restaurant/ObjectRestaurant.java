package com.example.testrappi.models.restaurant;

import com.example.testrappi.models.restaurant.Restaurant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ObjectRestaurant implements Serializable {

    @Expose
    @SerializedName("restaurant")
    private Restaurant restaurant;

    public ObjectRestaurant() {
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
