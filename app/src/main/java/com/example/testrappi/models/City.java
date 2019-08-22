package com.example.testrappi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @Expose
    @SerializedName("id")
    private Integer id;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("country_id")
    private Integer country_id;

    @Expose
    @SerializedName("country_name")
    private String country_name;

    @Expose
    @SerializedName("country_flag_url")
    private String country_flag_url;

    @Expose
    @SerializedName("should_experiment_with")
    private Integer should_experiment_with;

    @Expose
    @SerializedName("discovery_enabled")
    private Integer discovery_enabled;

    @Expose
    @SerializedName("has_new_ad_formatlatitude")
    private Integer has_new_ad_format;

    @Expose
    @SerializedName("is_state")
    private Integer is_state;

    @Expose
    @SerializedName("state_id")
    private Integer state_id;

    @Expose
    @SerializedName("state_name")
    private String state_name;

    @Expose
    @SerializedName("state_code")
    private String state_code;

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_flag_url() {
        return country_flag_url;
    }

    public void setCountry_flag_url(String country_flag_url) {
        this.country_flag_url = country_flag_url;
    }

    public Integer getShould_experiment_with() {
        return should_experiment_with;
    }

    public void setShould_experiment_with(Integer should_experiment_with) {
        this.should_experiment_with = should_experiment_with;
    }

    public Integer getDiscovery_enabled() {
        return discovery_enabled;
    }

    public void setDiscovery_enabled(Integer discovery_enabled) {
        this.discovery_enabled = discovery_enabled;
    }

    public Integer getHas_new_ad_format() {
        return has_new_ad_format;
    }

    public void setHas_new_ad_format(Integer has_new_ad_format) {
        this.has_new_ad_format = has_new_ad_format;
    }

    public Integer getIs_state() {
        return is_state;
    }

    public void setIs_state(Integer is_state) {
        this.is_state = is_state;
    }

    public Integer getState_id() {
        return state_id;
    }

    public void setState_id(Integer state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }
}
