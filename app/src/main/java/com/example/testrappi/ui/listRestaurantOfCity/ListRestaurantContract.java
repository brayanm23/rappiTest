package com.example.testrappi.ui.listRestaurantOfCity;

import com.example.testrappi.api.observer.BaseContract;
import com.example.testrappi.models.collection.ObjectCollection;
import com.example.testrappi.models.restaurant.ObjectRestaurant;

import java.util.List;

public interface ListRestaurantContract {

    interface View {

        void viewRestaurants(List<ObjectRestaurant> restaurants);

        void viewCollections(List<ObjectCollection> collections);

        void showErrorMessage(String message);

    }

    interface Presenter extends BaseContract.ServicePresenter{

        void getRestaurants(Integer city_id);

        void getCollections(Integer city_id);

    }
}
