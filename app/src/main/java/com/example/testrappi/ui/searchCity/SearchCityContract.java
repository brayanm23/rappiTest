package com.example.testrappi.ui.searchCity;


import com.example.testrappi.api.observer.BaseContract;
import com.example.testrappi.models.city.City;

import java.util.List;

public interface SearchCityContract {

    interface View {

        void viewCities(List<City> listCity);

        void showErrorMessage(String message);

    }

    interface Presenter extends BaseContract.ServicePresenter{

        void getCities(String query);

    }
}
