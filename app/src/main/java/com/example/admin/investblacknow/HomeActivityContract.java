package com.example.admin.investblacknow;

import java.util.List;

/**
 * Created by Admin on 8/18/2018.
 */

public interface HomeActivityContract {

    interface View extends BaseView{
        void setAdapter(List<Contact> contactList);
    }

    interface Presenter extends BasePresenter<View>{
        void setAdapter(List<Contact> contactList);
    }
}
