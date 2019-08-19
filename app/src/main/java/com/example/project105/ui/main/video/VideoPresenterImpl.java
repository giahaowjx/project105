package com.example.project105.ui.main.video;

import android.util.Log;

import com.example.project105.data.DataManager;
import com.example.project105.ui.base.BasePresenter;
import com.example.project105.utils.NetworkUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VideoPresenterImpl<V extends VideoView> extends BasePresenter<V> implements VideoPresenter<V> {

    private static final String TAG = "VideoPresenterImpl";

    @Inject
    public VideoPresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void refresh(String count) {
        getDataManager().doVideoInfoListPostApiCall(NetworkUtils.generateRequestBody(count))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonArray>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d(TAG, "onError: " + e.toString());

                    }

                    @Override
                    public void onNext(JsonArray jsonArray) {

                        Log.d(TAG, "onNext: begin");

                        Gson gson = new Gson();
                        List<VideoInfo> videoInfoList = gson.fromJson(jsonArray.toString(),
                                new TypeToken<List<VideoInfo>>(){}.getType());

                        Log.d(TAG, "onNext: List length : " + videoInfoList.size());

                        getMvpView().showVideoList(videoInfoList);
                    }
                });
    }
}
