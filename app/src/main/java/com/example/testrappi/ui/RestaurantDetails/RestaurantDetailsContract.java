package com.example.testrappi.ui.RestaurantDetails;

import com.example.testrappi.api.observer.BaseContract;
import com.example.testrappi.models.city.City;
import com.example.testrappi.models.review.ObjectReview;

import java.util.List;

public interface RestaurantDetailsContract {

    interface View {

        void viewReview(List<ObjectReview> reviews);

        void showErrorMessage(String message);

    }

    interface Presenter extends BaseContract.ServicePresenter{

        void getReview(Integer res_id);

    }
}
