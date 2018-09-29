package com.example.admin.investblacknow;

/**
 * Created by Admin on 8/18/2018.
 */

public interface BasePresenter<V extends BaseView> {
    void addView(V view);
    void removeView();
}
