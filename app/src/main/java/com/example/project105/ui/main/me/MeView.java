package com.example.project105.ui.main.me;

import com.example.project105.ui.base.MvpView;

public interface MeView extends MvpView {

    void openLoginActivity();

    void changeUserInfoView(String name, String uri);

}
