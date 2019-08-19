package com.example.project105.ui.main.video;

import com.example.project105.ui.base.MvpPresenter;

import java.util.List;

public interface VideoPresenter<V extends VideoView> extends MvpPresenter<V> {

    void refresh(String count);

}
