package com.example.admin.investblacknow;

/**
 * Created by Admin on 8/18/2018.
 */

public interface BaseRepository<P extends BasePresenter> {
    void addPresenter(P presenter);
    void removePresenter();
}
