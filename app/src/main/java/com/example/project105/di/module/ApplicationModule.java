package com.example.project105.di.module;

import android.app.Application;
import android.content.Context;

import com.example.project105.data.DataManager;
import com.example.project105.data.db.DbHelper;
import com.example.project105.data.db.DbHelperImpl;
import com.example.project105.data.db.DbOpenHelper;
import com.example.project105.data.network.ApiHelper;
import com.example.project105.data.network.ApiHelperImpl;
import com.example.project105.data.prefs.PreferencesHelper;
import com.example.project105.data.prefs.PreferencesHelperImpl;
import com.example.project105.di.ApplicationContext;
import com.example.project105.di.DatabaseInfo;
import com.example.project105.di.PreferenceInfo;
import com.example.project105.utils.ApiSettings;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @PreferenceInfo
    String provideSharePreferencesName() {
        return ApiSettings.PREFERENCES_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(PreferencesHelper preferencesHelper, ApiHelper apiHelper, DbHelper dbHelper) {
        return new DataManager(preferencesHelper, apiHelper, dbHelper);
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(DbOpenHelper helper) {
        return new DbHelperImpl(helper);
    }

    @Provides
    @Singleton
    DbOpenHelper provideDbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        return new DbOpenHelper(context, name);
    }

    @Provides
    @Singleton
    @DatabaseInfo
    String provideDataBaseName() {
        return "chordnote";
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper() {
        return new ApiHelperImpl();
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(@ApplicationContext Context context, @PreferenceInfo
            String name) {
        return new PreferencesHelperImpl(context,name);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }


}
