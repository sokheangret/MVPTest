package com.project.sokheangret.practicemvp.ui.login;

/**
 * Created by sokheangret on 12/15/17.
 */

public interface LoginInteractor {

    interface LoginResponseInteractor{
        void onUserNameError();
        void onPasswordError();
        void onLoginSuccess();
    }

    //get from network(RXandroid, retrofit)
    void login(String username, String password, LoginResponseInteractor responseInteractor);

}
