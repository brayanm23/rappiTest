package com.example.testrappi.ui.listRestaurantOfCity;

import android.content.Context;

import com.example.testrappi.R;
import com.example.testrappi.api.callers.RestaurantSearchApiCaller;
import com.example.testrappi.api.callers.CollectionsApiCaller;
import com.example.testrappi.api.callers.RestaurantSearchApiCaller;
import com.example.testrappi.api.observer.CallbackHandlingObserver;
import com.example.testrappi.api.services.GeneralRestService;
import com.example.testrappi.api.services.RestaurantRestService;
import com.example.testrappi.models.collection.ListCollections;
import com.example.testrappi.models.restaurant.ListRestaurants;

public class ListRestaurantPresenter implements ListRestaurantContract.Presenter {

    private Context context;
    private ListRestaurantContract.View mView;
    private CallbackHandlingObserver<ListRestaurants> observableRestaurants;
    private CallbackHandlingObserver<ListCollections> observableCollections;


    public ListRestaurantPresenter(Context context, ListRestaurantContract.View mView){
        this.context = context;
        this.mView = mView;
    }

    @Override
    public void getRestaurants(Integer city_id) {
        setObservableRestaurants();
        final RestaurantSearchApiCaller caller = RestaurantRestService.getRestaurants(city_id);
        caller.callApi().subscribeWith(observableRestaurants);

    }

    @Override
    public void getCollections(Integer city_id) {
        setObservableCollections();
        final CollectionsApiCaller caller = GeneralRestService.getCollections(city_id);
        caller.callApi().subscribeWith(observableCollections);
    }

    private void setObservableRestaurants() {
        observableRestaurants = new CallbackHandlingObserver<ListRestaurants>(ListRestaurantPresenter.this, RestaurantSearchApiCaller.class) {
            @Override
            protected void onSuccess(ListRestaurants data) {
                if(data.getListRestaurants()!=null)
                    mView.viewRestaurants(data.getListRestaurants());
            }
        };
    }

    private void setObservableCollections() {
        observableCollections = new CallbackHandlingObserver<ListCollections>(ListRestaurantPresenter.this, CollectionsApiCaller.class) {
            @Override
            protected void onSuccess(ListCollections data) {
                if(data.getListCollections()!=null)
                    mView.viewCollections(data.getListCollections());
            }
        };
    }

    @Override
    public void onUnknownError(String error, Class caller) {
        if(caller.equals(RestaurantSearchApiCaller.class) || caller.equals(CollectionsApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }

    @Override
    public void onTimeoutError(Class caller) {
        if(caller.equals(RestaurantSearchApiCaller.class) || caller.equals(CollectionsApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_time_out));
        }
    }

    @Override
    public void onNetworkError(Class caller) {
        if(caller.equals(RestaurantSearchApiCaller.class) || caller.equals(CollectionsApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_ocurred));
        }
    }

    @Override
    public void onBadRequestError(Class caller, String messageError) {
        if(caller.equals(RestaurantSearchApiCaller.class) || caller.equals(CollectionsApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }

    @Override
    public void onServerError(Class caller) {
        if(caller.equals(RestaurantSearchApiCaller.class) || caller.equals(CollectionsApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }
}
