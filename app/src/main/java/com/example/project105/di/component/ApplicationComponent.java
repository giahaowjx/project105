package com.example.project105.di.component;

import com.example.project105.Project105App;
import com.example.project105.data.DataManager;
import com.example.project105.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(Project105App app);

    DataManager provideDataManager();

    OkHttpClient provideOkHttpClient();
}
