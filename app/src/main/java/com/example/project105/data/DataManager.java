package com.example.project105.data;

import com.example.project105.data.db.DbHelper;
import com.example.project105.data.network.ApiHeader;
import com.example.project105.data.network.ApiHelper;
import com.example.project105.data.prefs.PreferencesHelper;
import com.google.gson.JsonArray;

import okhttp3.RequestBody;
import rx.Observable;

public class DataManager implements DataManagerApi {

    private PreferencesHelper preferencesHelper;

    private ApiHelper apiHelper;

    private DbHelper dbHelper;

    @Override
    public String getCurrentUserEmail() {
        return preferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        preferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserPass() {
        return preferencesHelper.getCurrentUserPass();
    }

    @Override
    public void setCurrentUserPass(String password) {
        preferencesHelper.setCurrentUserPass(password);
    }

    public DataManager(PreferencesHelper preferencesHelper, ApiHelper apiHelper, DbHelper dbHelper) {
        this.preferencesHelper = preferencesHelper;
        this.apiHelper = apiHelper;
        this.dbHelper = dbHelper;
    }

    // PreferencesHelper Interface
    @Override
    public boolean getCurrentLoginState() {
        return preferencesHelper.getCurrentLoginState();
    }

    @Override
    public void setCurrentLoginState(boolean state) {
        preferencesHelper.setCurrentLoginState(state);
    }

    @Override
    public Long getCurrentUserId() {
        return preferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long id) {
        preferencesHelper.setCurrentUserId(id);
    }

    @Override
    public ApiHeader getApiHeader() {
        return null;
    }

    // ApiHelper interface


    @Override
    public Observable<JsonArray> doVideoInfoListPostApiCall(RequestBody requestBody) {
        return apiHelper.doVideoInfoListPostApiCall(requestBody);
    }

    @Override
    public void setEmailToIdMap(String email, long id) {
        preferencesHelper.setEmailToIdMap(email, id);
    }

    @Override
    public Long getIdUsingEmail(String email) {
        return preferencesHelper.getIdUsingEmail(email);
    }

    @Override
    public void deleteEmailToIdMap(String email) {

    }

    @Override
    public void resetCurrentLoginInfo() {
        preferencesHelper.resetCurrentLoginInfo();
    }
}
