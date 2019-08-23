package com.example.testrappi.api.callers;

import com.example.testrappi.api.definitions.GeneralRestApi;
import com.example.testrappi.models.collection.ListCollections;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CollectionsApiCaller extends ApiCaller<GeneralRestApi>{

    private Integer city_id;

    public CollectionsApiCaller(GeneralRestApi api, Integer city_id) {
        super(api);
        this.city_id = city_id;
    }

    @Override
    public Observable<ListCollections> callApi() {
        return API.getZomatoCollectionsInCity("134c9509a1a71732f48dcf7ae96cf02c", city_id, 8)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
