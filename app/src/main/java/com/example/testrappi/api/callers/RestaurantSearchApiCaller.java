package com.example.testrappi.api.callers;

import com.example.testrappi.api.definitions.RestaurantRestApi;
import com.example.testrappi.models.restaurant.ListRestaurants;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RestaurantSearchApiCaller extends ApiCaller<RestaurantRestApi> {

    private Integer city_id;
    private String collection_id;

    public RestaurantSearchApiCaller(RestaurantRestApi api, Integer city_id, String collection_id) {
        super(api);
        this.city_id = city_id;
        this.collection_id = collection_id;
    }

    @Override
    public Observable<ListRestaurants> callApi() {
        return API.searchOfRestautants("134c9509a1a71732f48dcf7ae96cf02c", city_id, "city", collection_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
