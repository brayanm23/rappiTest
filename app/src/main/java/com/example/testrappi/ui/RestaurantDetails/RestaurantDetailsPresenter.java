package com.example.testrappi.ui.RestaurantDetails;

import android.content.Context;
import android.util.Log;

import com.example.testrappi.R;
import com.example.testrappi.api.callers.ReviewsApiCaller;
import com.example.testrappi.api.observer.CallbackHandlingObserver;
import com.example.testrappi.api.services.RestaurantRestService;
import com.example.testrappi.models.review.ListReview;

public class RestaurantDetailsPresenter implements RestaurantDetailsContract.Presenter {


    private Context context;
    private RestaurantDetailsContract.View mView;
    private CallbackHandlingObserver<ListReview> observableReviews;

    public RestaurantDetailsPresenter(Context context, RestaurantDetailsContract.View mView){
        this.context = context;
        this.mView = mView;
    }
    @Override
    public void getReview(Integer res_id) {
        setObservableReviews();
        final ReviewsApiCaller caller = RestaurantRestService.getReviews(res_id);
        caller.callApi().subscribeWith(observableReviews);
    }

    private void setObservableReviews() {
        observableReviews = new CallbackHandlingObserver<ListReview>(RestaurantDetailsPresenter.this, ReviewsApiCaller.class) {
            @Override
            protected void onSuccess(ListReview data) {
                if(data.getListReviews()!=null)
                    mView.viewReview(data.getListReviews());
            }
        };
    }

    @Override
    public void onUnknownError(String error, Class caller) {
        if(caller.equals(ReviewsApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }

    @Override
    public void onTimeoutError(Class caller) {
        if(caller.equals(ReviewsApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_time_out));
        }
    }

    @Override
    public void onNetworkError(Class caller) {
        if(caller.equals(ReviewsApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_ocurred));
        }
    }

    @Override
    public void onBadRequestError(Class caller, String messageError) {
        if(caller.equals(ReviewsApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }

    @Override
    public void onServerError(Class caller) {
        if(caller.equals(ReviewsApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }
}
