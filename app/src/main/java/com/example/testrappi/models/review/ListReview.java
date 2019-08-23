package com.example.testrappi.models.review;

import com.example.testrappi.models.restaurant.ObjectRestaurant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ListReview implements Serializable {

    @Expose
    @SerializedName("user_reviews")
    private List<ObjectReview> listReviews;

    @Expose
    @SerializedName("reviews_count")
    private Integer reviews_count;

    @Expose
    @SerializedName("reviews_start")
    private Integer reviews_start;

    @Expose
    @SerializedName("reviews_shown")
    private Integer reviews_shown;

    public ListReview() {
    }

    public List<ObjectReview> getListReviews() {
        return listReviews;
    }

    public void setListReviews(List<ObjectReview> listReviews) {
        this.listReviews = listReviews;
    }

    public Integer getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(Integer reviews_count) {
        this.reviews_count = reviews_count;
    }

    public Integer getReviews_start() {
        return reviews_start;
    }

    public void setReviews_start(Integer reviews_start) {
        this.reviews_start = reviews_start;
    }

    public Integer getReviews_shown() {
        return reviews_shown;
    }

    public void setReviews_shown(Integer reviews_shown) {
        this.reviews_shown = reviews_shown;
    }
}
