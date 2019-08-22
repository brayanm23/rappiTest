package com.example.testrappi.api.callers;

import com.example.testrappi.api.definitions.GeneralRestApi;
import com.example.testrappi.models.City;
import com.example.testrappi.models.ListCities;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CitiesApiCaller extends ApiCaller<GeneralRestApi>{

    private String query;

    public CitiesApiCaller(GeneralRestApi api, String query) {
        super(api);
        this.query = query;
    }

    @Override
    public Observable<ListCities> callApi() {
        return API.getCityDetails("134c9509a1a71732f48dcf7ae96cf02c", query, null,null,null,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
