package com.example.admin.investblacknow;

import android.app.Activity;
import android.view.View;

/**
 * Created by Admin on 8/25/2018.
 */

public class LoginActivityPresenter implements LoginActivityContract.Presenter {

    LoginActivityContract.View view;
    LoginActivityRepository repository;

    @Override
    public void addView(LoginActivityContract.View view) {
        this.view = view;
        this.repository = LoginActivityRepository.getInstance();
        repository.addPresenter(this);
    }

    @Override
    public void removeView() {

    }

    @Override
    public void showFailedLogin() {
        view.showFailedLogin();
    }

    @Override
    public void launchSigninActivity() {
        view.launchSigninActivity();
    }

    @Override
    public void startHomeActivity(Contact contact) {
        view.startHomeActivity(contact);
    }

    public void loginUser(View view, String email, String password, Activity activity){
        repository.loginUser(view, email, password, activity);
    }
}
