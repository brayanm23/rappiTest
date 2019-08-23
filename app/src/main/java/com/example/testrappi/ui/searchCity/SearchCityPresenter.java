package com.example.testrappi.ui.searchCity;

import android.content.Context;

import com.example.testrappi.R;
import com.example.testrappi.api.callers.CitiesApiCaller;
import com.example.testrappi.api.callers.RestaurantSearchApiCaller;
import com.example.testrappi.api.observer.CallbackHandlingObserver;
import com.example.testrappi.api.services.GeneralRestService;
import com.example.testrappi.models.city.ListCities;

public class SearchCityPresenter implements SearchCityContract.Presenter {

    private Context context;
    private SearchCityContract.View mView;
    private CallbackHandlingObserver<ListCities> observableCities;

    public SearchCityPresenter(Context context, SearchCityContract.View mView){
        this.context = context;
        this.mView = mView;
    }

    @Override
    public void getCities(String query) {
        setObservableCities();

        final CitiesApiCaller caller = GeneralRestService.getCities(query);

        caller.callApi().subscribeWith(observableCities);
    }

    private void setObservableCities() {
        observableCities = new CallbackHandlingObserver<ListCities>(SearchCityPresenter.this, RestaurantSearchApiCaller.class) {
            @Override
            protected void onSuccess(ListCities data) {
                mView.viewCities(data.getListCities());
            }
        };
    }

    @Override
    public void onUnknownError(String error, Class caller) {
        if(caller.equals(CitiesApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }

    @Override
    public void onTimeoutError(Class caller) {
        if(caller.equals(CitiesApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_time_out));
        }
    }

    @Override
    public void onNetworkError(Class caller) {
        if(caller.equals(CitiesApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_ocurred));
        }
    }

    @Override
    public void onBadRequestError(Class caller, String messageError) {
        if(caller.equals(CitiesApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }

    @Override
    public void onServerError(Class caller) {
        if(caller.equals(CitiesApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }
}
