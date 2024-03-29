package com.example.testrappi.api.definitions;

import com.example.testrappi.models.restaurant.ListRestaurants;
import com.example.testrappi.models.review.ListReview;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RestaurantRestApi {

    public static String url = "https://developers.zomato.com/api/v2.1/";

    @GET("reviews")
    Observable<ListReview> getRewiews(@Header("user_key") String user_key,
                                      @Query("res_id") Integer res_id);

    @GET("search")
    Observable<ListRestaurants> searchOfRestautants(@Header("user_key") String user_key,
                                                    @Query("entity_id") Integer city_id,
                                                    @Query("entity_type") String entity_type,
                                                    @Query("collection_id") String collection_id);

}
