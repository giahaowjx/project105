package com.example.project105.data.network;

import com.google.gson.JsonArray;

import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

public interface NetworkService {

    @Multipart
    @POST("video/list")
    Observable<JsonArray> postVideoInfoRequest(@Part("count") RequestBody count);
}
