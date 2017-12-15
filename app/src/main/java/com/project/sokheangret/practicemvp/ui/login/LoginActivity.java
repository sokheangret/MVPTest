package com.project.sokheangret.practicemvp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.project.sokheangret.practicemvp.R;
import com.project.sokheangret.practicemvp.base.BaseActivity;
import com.project.sokheangret.practicemvp.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements Presenter.LoginView{

    Presenter.LoginPresenter loginPresenter;

    @BindView(R.id.etUserName)
    EditText etUsername;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btLogin)
    Button btLogin;
    @BindView(R.id.btCancel)
    Button btCancel;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //inject presenter object
        loginPresenter = new LoginPresenterImpl(this);
    }

    @OnClick(R.id.btLogin)
    public void onBtLoginClicked() {
        loginPresenter.onLoginCredential(etUsername.getText().toString(),etPassword.getText().toString());
    }

    @OnClick(R.id.btCancel)
    public void onBtCancelClicked() {

    }

    @Override
    public void onShowProgressBar() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void onHideProgressBar() {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public void onUserNameError() {
        etUsername.setError("Username can not blank!");
    }

    @Override
    public void onPasswordError() {
        etPassword.setError("Password can not blank!");
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
