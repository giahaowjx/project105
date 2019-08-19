package com.example.project105.di.module;


import androidx.appcompat.app.AppCompatActivity;

import com.example.project105.data.DataManager;
import com.example.project105.ui.login.LoginPresenter;
import com.example.project105.ui.login.LoginPresenterImpl;
import com.example.project105.ui.login.LoginView;
import com.example.project105.ui.main.me.MePresenter;
import com.example.project105.ui.main.me.MePresenterImpl;
import com.example.project105.ui.main.me.MeView;
import com.example.project105.ui.main.video.VideoPresenter;
import com.example.project105.ui.main.video.VideoPresenterImpl;
import com.example.project105.ui.main.video.VideoView;
import com.example.project105.ui.register.RegisterPresenter;
import com.example.project105.ui.register.RegisterPresenterImpl;
import com.example.project105.ui.register.RegisterView;
import com.example.project105.ui.splash.SplashPresenter;
import com.example.project105.ui.splash.SplashPresenterImpl;
import com.example.project105.ui.splash.SplashView;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    SplashPresenter<SplashView> provideSplashPresenter(DataManager manager) {
        return new SplashPresenterImpl<>(manager);
    }

    @Provides
    RegisterPresenter<RegisterView> provideRegisterPresenter(DataManager manager) {
        return new RegisterPresenterImpl<>(manager);
    }

    @Provides
    LoginPresenter<LoginView> provideLoginPresenter(DataManager manager) {
        return new LoginPresenterImpl<>(manager);
    }

    @Provides
    MePresenter<MeView> provideMePresenter(DataManager manager) {
        return new MePresenterImpl<>(manager);
    }

    @Provides
    VideoPresenter<VideoView> provideStudyPresenter(DataManager manager) {
        return new VideoPresenterImpl<>(manager);
    }

}
