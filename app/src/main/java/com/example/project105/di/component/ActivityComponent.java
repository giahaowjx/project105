package com.example.project105.di.component;

import com.example.project105.di.module.ActivityModule;
import com.example.project105.di.scope.PerActivity;
import com.example.project105.ui.login.LoginActivity;
import com.example.project105.ui.main.MainActivity;
import com.example.project105.ui.main.me.MeFragment;
import com.example.project105.ui.main.video.VideoFragment;
import com.example.project105.ui.register.RegisterActivity;
import com.example.project105.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(MainActivity activity);

    void inject(RegisterActivity activity);

    void inject(MeFragment fragment);

    void inject(VideoFragment fragment);
}
