package com.example.testrappi.models.restaurant;

import com.example.testrappi.models.Location;
import com.example.testrappi.models.photo.ObjectPhoto;
import com.example.testrappi.models.photo.Photo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Restaurant implements Serializable {

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("url")
    private String url;

    @Expose
    @SerializedName("cuisines")
    private String cuisines;

    @Expose
    @SerializedName("timings")
    private String timings;

    @Expose
    @SerializedName("average_cost_for_two")
    private String average_cost_for_two;

    @Expose
    @SerializedName("currency")
    private String currency;

    @Expose
    @SerializedName("phone_numbers")
    private String phone_numbers;

    @Expose
    @SerializedName("featured_image")
    private String featured_image;

    @Expose
    @SerializedName("thumb")
    private String thumb;

    @Expose
    @SerializedName("location")
    private Location location;

    @Expose
    @SerializedName("photos")
    private List<ObjectPhoto> photos;

    public Restaurant() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public void setFeatured_image(String featured_image) {
        this.featured_image = featured_image;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public String getAverage_cost_for_two() {
        return average_cost_for_two;
    }

    public void setAverage_cost_for_two(String average_cost_for_two) {
        this.average_cost_for_two = average_cost_for_two;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPhone_numbers() {
        return phone_numbers;
    }

    public void setPhone_numbers(String phone_numbers) {
        this.phone_numbers = phone_numbers;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<ObjectPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<ObjectPhoto> photos) {
        this.photos = photos;
    }
}
