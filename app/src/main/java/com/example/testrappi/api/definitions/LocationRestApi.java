package com.example.testrappi.api.definitions;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface LocationRestApi {

    public static String url = "https://developers.zomato.com/api/v2.1/";

    @GET("location_details")
    Observable<?> getZomatoLocationDetails(@Header("user_key") String user_key, @Query("entity_id") Integer entity_id, @Query("entity_type") Integer entity_type);

    @GET("locations")
    Observable<?> searchForLocations(@Header("user_key") String user_key, @Query("query") String query, @Query("lat") Double lat, @Query("lon") Double lon, @Query("count") Integer count);

}
