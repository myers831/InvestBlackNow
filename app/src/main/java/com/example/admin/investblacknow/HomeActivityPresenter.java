package com.example.admin.investblacknow;

import java.util.List;

/**
 * Created by Admin on 8/18/2018.
 */

public class HomeActivityPresenter implements HomeActivityContract.Presenter {

    HomeActivityContract.View view;
    HomeActivityRepository repository;

    @Override
    public void addView(HomeActivityContract.View view) {
        this.view = view;
        this.repository = HomeActivityRepository.getInstance();
        repository.addPresenter(this);
    }

    @Override
    public void removeView() {

    }

    public void getContacts(){
        repository.getContacts();
    }

    public void setAdapter(List<Contact> contactList){
        view.setAdapter(contactList);
    }
}
