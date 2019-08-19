package com.example.project105.ui.register;

import android.util.Log;

import com.example.project105.data.DataManager;
import com.example.project105.ui.base.BasePresenter;
import com.example.project105.utils.NetworkUtils;

import java.util.Map;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RegisterPresenterImpl<V extends RegisterView> extends BasePresenter<V> implements RegisterPresenter<V> {

    private static final String TAG = "RegisterPresenterImpl";

    @Inject
    public RegisterPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
    }

    @Override
    public void sendCheckCode(String email) {

        getMvpView().showLoading();

        getMvpView().hideLoading();

    }

    @Override
    public void register(Map<String, String> request) {

        getMvpView().showLoading();

//        getDataManager().doRegisterApiCall(NetworkUtils.generateRegisterRequestBody(request))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<RegisterResponse>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d(TAG, "onCompleted: Register ChordNote");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "onError: Register ChordNote");
//                    }
//
//                    @Override
//                    public void onNext(RegisterResponse registerResponse) {
//
//                        Log.d(TAG, "onNext: Register ChordNote");
//
//                        if (registerResponse.getStatusCode() == 1001) {
//                            getMvpView().showToastText("该邮箱已有用户注册！");
//                        } else if (registerResponse.getStatusCode() == 1002) {
//                            getMvpView().showToastText("验证码错误");
//                        } else if (registerResponse.getStatusCode() == 1003) {
//                            getMvpView().showToastText("该邮箱未请求验证码");
//                        } else if (registerResponse.getStatusCode() == 1004) {
//                            getMvpView().showToastText("验证码已过期，请重新获取");
//                        } else if (registerResponse.getStatusCode() == 1000) {
//                            getMvpView().showToastText("注册成功");
//                            getMvpView().closeRegisterView();
//                        }
//                    }
//                });

        getMvpView().hideLoading();
    }

}
