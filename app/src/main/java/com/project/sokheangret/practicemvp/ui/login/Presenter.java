package com.project.sokheangret.practicemvp.ui.login;

/**
 * Created by sokheangret on 12/15/17.
 */

public interface Presenter {

    interface LoginView{
        void onShowProgressBar();
        void onHideProgressBar();
        void onUserNameError();
        void onPasswordError();
        void onLoginSuccess();
    }

    interface LoginPresenter{

        void onDestroyView();
        void onLoginCredential(String userName, String password);

    }


}
