package com.example.testrappi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListCities {
    @Expose
    @SerializedName("location_suggestions")
    List<City> listCities;

    public ListCities() {
    }

    public List<City> getListCities() {
        return listCities;
    }

    public void setListCities(List<City> listCities) {
        this.listCities = listCities;
    }
}
