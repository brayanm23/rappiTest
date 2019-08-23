package com.example.testrappi.models.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ObjectPhoto implements Serializable {

    @Expose
    @SerializedName("photo")
    private Photo photo;

    public ObjectPhoto() {
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
