package com.example.project105.ui.base;

import com.example.project105.data.DataManager;

import javax.inject.Inject;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private DataManager manager;
    private V mMvpView;

    @Inject
    public BasePresenter(DataManager manager) {
        this.manager = manager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()); // throw new Exception();
    }

    public DataManager getDataManager() {
        return manager;
    }

    @Override
    public void handleApiError() {
    }
}
