package com.example.testrappi.ui.RestaurantDetails;

import com.example.testrappi.api.observer.BaseContract;
import com.example.testrappi.models.city.City;

import java.util.List;

public interface RestaurantDetailsContract {

    interface View {

        void viewCities();

        void showErrorMessage(String message);

    }

    interface Presenter extends BaseContract.ServicePresenter{

        void getCities();

    }
}
