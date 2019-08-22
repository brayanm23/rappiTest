package com.example.testrappi.api.callers;

import io.reactivex.Observable;

public abstract class ApiCaller<T> {

    public static final String NO_ID = "NO_ID";
    public static final int SUCCESS = 200;
    public static final int NO_INTERNET_CONNECTION = 502;
    public static final int BAD_REQUEST = 404;
    public static final int TIMEOUT = 600;
    public static final int UNKNOWN = 1;
    public static final int NO_RESULTS = 2;
    public static final int CANT_GET_RESULT = -500;
    /**
     * Instancia de la API
     */
    protected final T API;

    public ApiCaller(T api) {
        API = api;
    }

    /**
     * Realiza la llamada a la API
     */
    public abstract Observable<?> callApi();

}
