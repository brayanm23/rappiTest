package com.example.testrappi.api.services;

import com.example.testrappi.api.callers.RestaurantSearchApiCaller;
import com.example.testrappi.api.definitions.RestaurantRestApi;

public class RestaurantRestService extends AbstractRestService<RestaurantRestApi> {

    private static RestaurantRestService serviceInstance;

    public RestaurantRestService() {
        super();
    }

    private static RestaurantRestService getInstance() {
        serviceInstance = new RestaurantRestService();
        return serviceInstance;
    }

    @Override
    protected Class<RestaurantRestApi> getRestApiDefinitionInterface() {
        return RestaurantRestApi.class;
    }

    @Override
    protected String getServiceEndPoint() {
        return RestaurantRestApi.url;
    }

    public static RestaurantSearchApiCaller getRestaurants(Integer city_id){
        return new RestaurantSearchApiCaller(getInstance().getService(), city_id);
    }
}
