package com.example.project105.ui.play;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project105.R;
import com.example.project105.ui.base.BaseActivity;
import com.example.project105.ui.widget.CommonAppBar;
import com.example.project105.utils.ApiSettings;

import butterknife.BindView;
import butterknife.ButterKnife;
import tv.danmaku.ijk.media.example.application.Settings;
import tv.danmaku.ijk.media.example.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.example.widget.media.IjkVideoView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class PlayActivity extends BaseActivity {

    @BindView(R.id.player_videoview)
    IjkVideoView mVideoView;

    private AndroidMediaController mMediaController;

    private String mVideoPath;

    @BindView(R.id.hud_view)
    TableLayout mHudView;

    private Settings mSettings;

    private String videoToken;

    @BindView(R.id.play_common_app_bar)
    CommonAppBar appBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        ButterKnife.bind(this);



        videoToken = getIntent().getStringExtra("token");

        startVideo();

    }

//
    private void startVideo() {
        mSettings = new Settings(this);
        mVideoPath = ApiSettings.BASE_URL + "video/file/" + videoToken;

        mMediaController = new AndroidMediaController(this, false);

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();

        ijkMediaPlayer.setOption(1, "analyzemaxduration", 100L);
        ijkMediaPlayer.setOption(1, "probesize", 10240L);
        ijkMediaPlayer.setOption(1, "flush_packets", 1L);
        ijkMediaPlayer.setOption(4, "packet-buffering", 0L);
        ijkMediaPlayer.setOption(4, "framedrop", 1L);

        mVideoView.setMediaController(mMediaController);
        mVideoView.setHudView(mHudView);

        if (TextUtils.isEmpty(mVideoPath)) {
            Toast.makeText(this,
                    "No Video Found! Press Back Button To Exit",
                    Toast.LENGTH_LONG).show();
        } else {
            mVideoView.setVideoURI(Uri.parse(mVideoPath));
            mVideoView.start();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mVideoView.stopPlayback();
        mVideoView.release(true);
        mVideoView.stopBackgroundPlay();
        IjkMediaPlayer.native_profileEnd();
    }

    public static Intent getIntent(Context context, String token) {
        Intent intent =  new Intent(context, PlayActivity.class);
        intent.putExtra("token", token);

        return intent;
    }

}
