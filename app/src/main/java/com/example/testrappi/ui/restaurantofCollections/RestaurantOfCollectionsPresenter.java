package com.example.testrappi.ui.restaurantofCollections;

import android.content.Context;

import com.example.testrappi.R;
import com.example.testrappi.api.callers.RestaurantSearchApiCaller;
import com.example.testrappi.api.observer.CallbackHandlingObserver;
import com.example.testrappi.api.services.RestaurantRestService;
import com.example.testrappi.models.restaurant.ListRestaurants;

public class RestaurantOfCollectionsPresenter implements RestaurantOfCollectionsContract.Presenter  {

    private Context context;
    private RestaurantOfCollectionsContract.View mView;
    private CallbackHandlingObserver<ListRestaurants> observableRestaurants;


    public RestaurantOfCollectionsPresenter(Context context, RestaurantOfCollectionsContract.View mView){
        this.context = context;
        this.mView = mView;
    }

    @Override
    public void getRestaurants(Integer city_id, String collection_id) {
        setObservableRestaurants();
        final RestaurantSearchApiCaller caller = RestaurantRestService.getRestaurantsOfCollections(city_id,collection_id);
        caller.callApi().subscribeWith(observableRestaurants);
    }

    private void setObservableRestaurants() {
        observableRestaurants = new CallbackHandlingObserver<ListRestaurants>(RestaurantOfCollectionsPresenter.this, RestaurantSearchApiCaller.class) {
            @Override
            protected void onSuccess(ListRestaurants data) {
                if(data.getListRestaurants()!=null)
                    mView.viewRestaurants(data.getListRestaurants());
            }
        };
    }

    @Override
    public void onUnknownError(String error, Class caller) {
        if(caller.equals(RestaurantSearchApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }

    @Override
    public void onTimeoutError(Class caller) {
        if(caller.equals(RestaurantSearchApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_time_out));
        }
    }

    @Override
    public void onNetworkError(Class caller) {
        if(caller.equals(RestaurantSearchApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_ocurred));
        }
    }

    @Override
    public void onBadRequestError(Class caller, String messageError) {
        if(caller.equals(RestaurantSearchApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }

    @Override
    public void onServerError(Class caller) {
        if(caller.equals(RestaurantSearchApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }
}
