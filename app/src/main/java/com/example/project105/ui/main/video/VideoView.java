package com.example.project105.ui.main.video;

import com.example.project105.ui.base.MvpView;

import java.util.List;

public interface VideoView extends MvpView {

    void showVideoList(List<VideoInfo> videoInfoList);

}
