package com.example.testrappi.models.collection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListCollections {

    @Expose
    @SerializedName("collections")
    private List<ObjectCollection> listCollections;

    public ListCollections() {
    }

    public List<ObjectCollection> getListCollections() {
        return listCollections;
    }

    public void setListCollections(List<ObjectCollection> listCollections) {
        this.listCollections = listCollections;
    }
}
