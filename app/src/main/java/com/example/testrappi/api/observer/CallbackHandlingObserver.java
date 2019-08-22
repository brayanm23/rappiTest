package com.example.testrappi.api.observer;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * Created by enava on 27/3/2018.
 */

public abstract class CallbackHandlingObserver<T> extends DisposableObserver<T> {

    private BaseContract.ServicePresenter presenter;
    private final Class caller;
    private String TAG = getClass().getSimpleName();

    public static final String NO_ID = "NO_ID";
    public static final int SUCCESS = 200;
    public static final int NO_INTERNET_CONNECTION = 502;
    public static final int BAD_REQUEST = 404;
    public static final int TIMEOUT = 600;
    public static final int DEFAULT = 700;
    public static final int UNKNOWN = 1;
    public static final int NO_RESULTS = 2;


    public CallbackHandlingObserver(BaseContract.ServicePresenter presenter, Class caller) {
        this.presenter = presenter;
        this.caller = caller;
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable ex) {
        int errorCode;
        String stringError = "";

        if (ex instanceof HttpException) {
             errorCode = ((HttpException) ex).response().code();

            if(errorCode == 400) {
                HttpException exception = (HttpException) ex;
                Response response = exception.response();
                try {
                    JSONObject jObjError = new JSONObject(response.errorBody().string());
                    stringError = jObjError.optString("error");
                } catch (JSONException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            handleErrorCode(errorCode, stringError, caller);
        } else if (ex instanceof SocketTimeoutException) {
            presenter.onTimeoutError(caller);
        } else if (ex instanceof IOException) {
            presenter.onNetworkError(caller);

        } else {
                 presenter.onUnknownError(ex.getMessage(), caller);
        }
    }

    private void handleErrorCode(int errorCode, String errorBody, Class caller) {

        Log.i(TAG, "handleErrorCode: codigo error " +errorCode);

         if(errorCode==500){
             presenter.onServerError(caller);
         }else if(errorCode >=400 && errorCode <500) {
             presenter.onBadRequestError(caller, errorBody);

         }

    }

    @Override
    public void onComplete() {
        //DO NOTHING
    }

    protected abstract void onSuccess(T data);
}