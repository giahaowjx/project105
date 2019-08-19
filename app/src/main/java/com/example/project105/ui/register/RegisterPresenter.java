package com.example.project105.ui.register;

import com.example.project105.ui.base.MvpPresenter;
import com.example.project105.ui.base.MvpView;

import java.util.Map;

public interface RegisterPresenter<V extends MvpView> extends MvpPresenter<V> {

    void sendCheckCode(String email);

    void register(Map<String, String> request);

}
