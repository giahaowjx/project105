package com.example.project105.ui.login;


import android.util.Log;

import com.example.project105.data.DataManager;
import com.example.project105.ui.base.BasePresenter;
import com.example.project105.utils.NetworkUtils;

import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginPresenterImpl<V extends LoginView> extends BasePresenter<V> implements LoginPresenter<V> {

    private static final String TAG = "LoginPresenterImpl";

    public LoginPresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
    }

    @Override
    public void Login(Map<String, String> request) {
        getMvpView().showLoading();


        getMvpView().hideLoading();
    }

}
