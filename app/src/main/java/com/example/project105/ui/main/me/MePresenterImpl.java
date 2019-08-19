package com.example.project105.ui.main.me;

import com.example.project105.data.DataManager;
import com.example.project105.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

public class MePresenterImpl<V extends MeView> extends BasePresenter<V> implements MePresenter<V> {

    @Inject
    public MePresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void goNextActivity() {
        if (!getDataManager().getCurrentLoginState()) {
            getMvpView().openLoginActivity();
        } else {
            return;
        }
    }

    @Override
    public void UpdateUserView() {

    }
}
