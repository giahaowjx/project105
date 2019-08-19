package com.example.project105.ui.main.video;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoInfo {

    @Expose
    @SerializedName("videoID")
    private int videoId;

    @Expose
    @SerializedName("VideoName")
    private String videoName;

    @Expose
    @SerializedName("videoToken")
    private String videoToken;

    @Expose
    @SerializedName("avatar")
    private String avatar;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoToken() {
        return videoToken;
    }

    public void setVideoToken(String videoToken) {
        this.videoToken = videoToken;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @NonNull
    @Override
    public String toString() {
        return getVideoName() + " " + getAvatar();
    }
}
