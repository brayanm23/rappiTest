package com.example.testrappi.api.callers;

import com.example.testrappi.api.definitions.RestaurantRestApi;
import com.example.testrappi.models.review.ListReview;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ReviewsApiCaller extends ApiCaller<RestaurantRestApi> {

    private Integer res_id;

    public ReviewsApiCaller(RestaurantRestApi api, Integer res_id) {
         super(api);
         this.res_id = res_id;
    }

    @Override
    public Observable<ListReview> callApi() {
        return API.getRewiews("134c9509a1a71732f48dcf7ae96cf02c", res_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
