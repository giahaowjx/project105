package com.example.project105.ui.login;

import com.example.project105.ui.base.MvpPresenter;
import com.example.project105.ui.base.MvpView;

import java.util.Map;

public interface LoginPresenter<V extends MvpView> extends MvpPresenter<V> {

    void Login(Map<String, String> request);

}
