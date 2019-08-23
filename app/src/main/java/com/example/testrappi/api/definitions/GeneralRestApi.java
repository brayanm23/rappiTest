package com.example.testrappi.api.definitions;

import com.example.testrappi.models.city.ListCities;
import com.example.testrappi.models.collection.ListCollections;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface GeneralRestApi {

    public static String url = "https://developers.zomato.com/api/v2.1/";

    @GET("cities")
    Observable<ListCities> getCityDetails(@Header("user_key") String user_key,
                                          @Query("q") String query,
                                          @Query("city_ids") String city_ids,
                                          @Query("lat") Double lat,
                                          @Query("lon") Double lon,
                                          @Query("count") Integer count);

    @GET("collections")
    Observable<ListCollections> getZomatoCollectionsInCity(@Header("user_key") String user_key,
                                                           @Query("city_id") Integer city_id,
                                                           @Query("count") Integer count);

}
