package com.example.testrappi.api.observer;

/**
 * Created by enava on 5/4/2018.
 */

/**
 * Base Contract.
 * All Contracts in the app needs to extend from this Contract
 */
public interface BaseContract {
    /**
     * Here is the Contract from the view to presenter.
     * Here you set any method from VIEW available to Presenter.
     */
    interface View {
        void setPresenter(BaseContract.Presenter presenter);

    }

    interface ServiceView extends BaseContract.View{

        void showUnknownError(String error);

        void showTimeoutError();

        void showNetworkError();

        void showBadRequestError();

        void showServerError();

        void setVisibilityProgressBar(boolean visibility);
    }

    /**
     * Here is the contract from the Presenter to the View.
     * Here you set any methods from PRESENTER available to View.
     */
    interface Presenter {

    }

    /**
     * Este es el contrato del Presentador a la Vista, el cual se va a encargar de recibir la respuesta de servicios web.
     */
    interface ServicePresenter extends BaseContract.Presenter {

        void onUnknownError(String error, Class caller);

        void onTimeoutError(Class caller);

        void onNetworkError(Class caller);

        void onBadRequestError(Class caller, String messageError);

        void onServerError(Class caller);

    }

}