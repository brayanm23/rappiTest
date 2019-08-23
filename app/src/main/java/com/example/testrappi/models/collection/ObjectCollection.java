package com.example.testrappi.models.collection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjectCollection {

    @Expose
    @SerializedName("collection")
    private Collection collection;

    public ObjectCollection() {
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}
