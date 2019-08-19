package com.example.project105.ui.main.me;

import com.example.project105.ui.base.MvpPresenter;

public interface MePresenter<V extends MeView> extends MvpPresenter<V> {

    void goNextActivity();

    void UpdateUserView();

}
