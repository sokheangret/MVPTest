package com.project.sokheangret.practicemvp.ui.login;

/**
 * Created by sokheangret on 12/15/17.
 */

class LoginPresenterImpl implements Presenter.LoginPresenter, LoginInteractor.LoginResponseInteractor{

    public Presenter.LoginView loginView;
    public LoginInteractor loginInteractor;

    public LoginPresenterImpl(Presenter.LoginView loginView){
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }
    @Override
    public void onDestroyView() {
        if(loginView!=null) loginView=null;
    }

    @Override
    public void onLoginCredential(String userName, String password) {
        if (loginView!=null){
            loginView.onShowProgressBar();
            loginInteractor.login(userName,password,this);
        }

    }

    @Override
    public void onUserNameError() {
        if(loginView!=null){
            loginView.onUserNameError();
            loginView.onHideProgressBar();
        }
    }

    @Override
    public void onPasswordError() {
        if(loginView!=null){
            loginView.onPasswordError();
            loginView.onHideProgressBar();
        }
    }

    @Override
    public void onLoginSuccess() {
        if(loginView!=null){
            loginView.onLoginSuccess();
            loginView.onHideProgressBar();
        }

    }
}
