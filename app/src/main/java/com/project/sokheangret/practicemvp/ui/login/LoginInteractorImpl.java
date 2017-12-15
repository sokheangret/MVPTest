package com.project.sokheangret.practicemvp.ui.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by sokheangret on 12/15/17.
 */

public class LoginInteractorImpl implements LoginInteractor {

    //Get data from network
    @Override
    public void login(final String username, final String password, final LoginResponseInteractor responseInteractor) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(TextUtils.isEmpty(username)){
                    responseInteractor.onUserNameError();
                }else if(TextUtils.isEmpty(password)){
                    responseInteractor.onPasswordError();
                }else {
                    responseInteractor.onLoginSuccess();
                }
            }
        }, 1000);

    }
}
