package com.example.project105.data.network;

import com.example.project105.utils.ApiSettings;
import com.google.gson.JsonArray;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;


public class ApiHelperImpl implements ApiHelper {

    private ApiHeader mApiHeader;

    private static final String TAG = "ApiHelperImpl";

    private Retrofit retrofit;

    private NetworkService service;

    @Inject
    public ApiHelperImpl() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);


        retrofit = new Retrofit.Builder()
                .baseUrl(ApiSettings.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build();

        service = retrofit.create(NetworkService.class);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Observable<JsonArray> doVideoInfoListPostApiCall(RequestBody requestBody) {
        return service.postVideoInfoRequest(requestBody);
    }
}
