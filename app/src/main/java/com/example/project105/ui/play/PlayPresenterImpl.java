package com.example.project105.ui.play;

import com.example.project105.data.DataManager;
import com.example.project105.ui.base.BasePresenter;
import com.example.project105.ui.base.MvpPresenter;

public class PlayPresenterImpl<V extends PlayView> extends BasePresenter<V> implements MvpPresenter<V> {

    public PlayPresenterImpl(DataManager manager) {
        super(manager);
    }
}
