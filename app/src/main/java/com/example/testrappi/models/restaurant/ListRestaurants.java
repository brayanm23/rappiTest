package com.example.testrappi.models.restaurant;

import com.example.testrappi.models.restaurant.ObjectRestaurant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListRestaurants {

    @Expose
    @SerializedName("restaurants")
    private List<ObjectRestaurant> listRestaurants;

    public ListRestaurants() {
    }

    public List<ObjectRestaurant> getListRestaurants() {
        return listRestaurants;
    }

    public void setListRestaurants(List<ObjectRestaurant> listRestaurants) {
        this.listRestaurants = listRestaurants;
    }
}
