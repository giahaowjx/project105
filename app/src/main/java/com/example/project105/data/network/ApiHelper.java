package com.example.project105.data.network;

import com.google.gson.JsonArray;

import okhttp3.RequestBody;
import rx.Observable;


public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<JsonArray> doVideoInfoListPostApiCall(RequestBody requestBody);
}
