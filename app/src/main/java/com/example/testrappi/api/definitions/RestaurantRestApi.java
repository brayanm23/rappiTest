package com.example.testrappi.api.definitions;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RestaurantRestApi {

    public static String url = "https://developers.zomato.com/api/v2.1/";

    @GET("restaurant")
    Observable<?> getRestaurantDetails(@Header("user_key") String user_key, @Query("res_id") Integer res_id);

    @GET("dailymenu")
    Observable<?> getDailyMenuOfrestaurant(@Header("user_key") String user_key, @Query("res_id") Integer res_id);

    @GET("reviews")
    Observable<?> getRestaurantRewiews(@Header("user_key") String user_key, @Query("res_id") Integer res_id);

    @GET("search")
    Observable<?> searchOfRestautants(@Header("user_key") String user_key, @Query("res_id") Integer res_id);

}
