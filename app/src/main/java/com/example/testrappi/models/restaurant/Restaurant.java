package com.example.testrappi.models.restaurant;

import com.example.testrappi.models.Location;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

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

    /*public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }*/

    /*
    "R":{  },
            "apikey":"134c9509a1a71732f48dcf7ae96cf02c",
            "id":"16771079",
            "name":"Lombardi's Pizza",
            "url":"https://www.zomato.com/new-york-city/lombardis-pizza-lower-east-side?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1",
            "location":{  },
            "switch_to_order_menu":0,
            "cuisines":"Pizza, Italian",
            "timings":"11:30 AM to 11 PM (Mon, Tue, Wed, Thu, Sun), 11:30 AM to 12 Midnight (Fri-Sat)",
            "average_cost_for_two":50,
            "price_range":3,
            "currency":"$",
            "highlights":[  ],
            "offers":[  ],
            "opentable_support":0,
            "is_zomato_book_res":0,
            "mezzo_provider":"OTHER",
            "is_book_form_web_view":0,
            "book_form_web_view_url":"",
            "book_again_url":"",
            "thumb":"https://b.zmtcdn.com/data/res_imagery/16771079_RESTAURANT_da60c9abb32fa64cddc148a2795ae43c_c.jpg?fit=around%7C200%3A200&crop=200%3A200%3B%2A%2C%2A",
            "user_rating":{  },
            "all_reviews_count":308,
            "photos_url":"https://www.zomato.com/new-york-city/lombardis-pizza-lower-east-side/photos?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1#tabtop",
            "photo_count":2169,
            "photos":[  ],
            "menu_url":"https://www.zomato.com/new-york-city/lombardis-pizza-lower-east-side/menu?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1&openSwipeBox=menu&showMinimal=1#tabtop",
            "featured_image":"https://b.zmtcdn.com/data/res_imagery/16771079_RESTAURANT_da60c9abb32fa64cddc148a2795ae43c_c.jpg",
            "has_online_delivery":0,
            "is_delivering_now":0,
            "include_bogo_offers":true,
            "deeplink":"zomato://restaurant/16771079",
            "is_table_reservation_supported":0,
            "has_table_booking":0,
            "events_url":"https://www.zomato.com/new-york-city/lombardis-pizza-lower-east-side/events#tabtop?utm_source=api_basic_user&utm_medium=api&utm_campaign=v2.1",
            "phone_numbers":"(212) 941-7994",
            "all_reviews":{  },
            "establishment":[  ],
            "establishment_types":[  ]
     */

}
