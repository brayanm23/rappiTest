package com.example.testrappi.models.review;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ObjectReview implements Serializable {

    @Expose
    @SerializedName("review")
    private Review review;

    public ObjectReview() {
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
