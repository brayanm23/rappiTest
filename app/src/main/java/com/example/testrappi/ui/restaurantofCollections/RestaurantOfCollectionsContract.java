package com.example.testrappi.ui.restaurantofCollections;

import com.example.testrappi.api.observer.BaseContract;
import com.example.testrappi.models.restaurant.ObjectRestaurant;

import java.util.List;

public interface RestaurantOfCollectionsContract {

    interface View {

        void viewRestaurants(List<ObjectRestaurant> restaurants);

        void showErrorMessage(String message);

    }

    interface Presenter extends BaseContract.ServicePresenter{

        void getRestaurants(Integer city_id, String collection_id);

    }
}
