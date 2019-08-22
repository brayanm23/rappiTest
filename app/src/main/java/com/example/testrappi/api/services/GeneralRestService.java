package com.example.testrappi.api.services;


import com.example.testrappi.api.callers.CitiesApiCaller;
import com.example.testrappi.api.definitions.GeneralRestApi;

public class GeneralRestService extends AbstractRestService<GeneralRestApi> {

    private static GeneralRestService serviceInstance;

    public GeneralRestService() {
        super();
    }

    private static GeneralRestService getInstance() {
        serviceInstance = new GeneralRestService();
        return serviceInstance;
    }

    @Override
    protected Class<GeneralRestApi> getRestApiDefinitionInterface() {
        return GeneralRestApi.class;
    }

    @Override
    protected String getServiceEndPoint() {
        return GeneralRestApi.url;
    }

    public static CitiesApiCaller getCities(String query){
        return new CitiesApiCaller(getInstance().getService(), query);
    }

}

