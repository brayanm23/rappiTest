package com.example.testrappi.models.collection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Collection {

    @Expose
    @SerializedName("collection_id")
    private Integer collection_id;

    @Expose
    @SerializedName("res_count")
    private Integer res_count;

    @Expose
    @SerializedName("image_url")
    private String image_url;

    @Expose
    @SerializedName("url")
    private String url;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("description")
    private String description;

    @Expose
    @SerializedName("share_url")
    private String share_url;

    public Collection() {
    }

    public Integer getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(Integer collection_id) {
        this.collection_id = collection_id;
    }

    public Integer getRes_count() {
        return res_count;
    }

    public void setRes_count(Integer res_count) {
        this.res_count = res_count;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }
}
