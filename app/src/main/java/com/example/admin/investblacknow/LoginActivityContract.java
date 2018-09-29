package com.example.admin.investblacknow;

import java.util.List;

/**
 * Created by Admin on 8/25/2018.
 */

public interface LoginActivityContract {

    interface View extends BaseView{
        void showFailedLogin();
        void launchSigninActivity();
        void startHomeActivity(Contact contact);
    }

    interface Presenter extends BasePresenter<LoginActivityContract.View>{
        void showFailedLogin();
        void launchSigninActivity();
        void startHomeActivity(Contact contact);
    }
}
