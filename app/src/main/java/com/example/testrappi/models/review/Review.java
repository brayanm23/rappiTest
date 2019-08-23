package com.example.testrappi.models.review;

import com.example.testrappi.models.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Review implements Serializable {

    @Expose
    @SerializedName("rating")
    private Float rating;

    @Expose
    @SerializedName("review_text")
    private String review_text;

    @Expose
    @SerializedName("review_time_friendly")
    private String review_time_friendly;

    @Expose
    @SerializedName("user")
    private User user;

    public Review() {
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public String getReview_time_friendly() {
        return review_time_friendly;
    }

    public void setReview_time_friendly(String review_time_friendly) {
        this.review_time_friendly = review_time_friendly;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
