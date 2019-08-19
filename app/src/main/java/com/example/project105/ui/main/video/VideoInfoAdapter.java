package com.example.project105.ui.main.video;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project105.R;
import com.example.project105.ui.play.PlayActivity;
import com.example.project105.utils.ApiSettings;

import java.util.List;

public class VideoInfoAdapter extends RecyclerView.Adapter<VideoInfoAdapter.ViewHolder> {

    private static final String TAG = "VideoInfoAdapter";
    
    private Context mContext;

    private List<VideoInfo> videoInfoList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView videoCover;
        TextView videoName;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            videoCover = (ImageView) cardView.findViewById(R.id.video_cover_img);
            videoName = (TextView) cardView.findViewById(R.id.video_name_text);
        }
    }

    public VideoInfoAdapter(List<VideoInfo> videoInfoList) {
        this.videoInfoList = videoInfoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_video, parent, false);

        final ViewHolder holder = new ViewHolder(view);

        Log.d(TAG, "onCreateViewHolder: Chord");
        
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VideoInfo videoInfo = videoInfoList.get(position);

        holder.videoName.setText(videoInfo.getVideoName());

        if (videoInfo.getAvatar().length() > 0) {
            Glide.with(mContext)
                    .load(ApiSettings.BASE_URL + "image/file/" + videoInfo.getAvatar())
                    .into(holder.videoCover);
        } else {
            Glide.with(mContext)
                    .load(R.drawable.bulb)
                    .into(holder.videoCover);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(PlayActivity.getIntent(mContext, videoInfo.getVideoToken()));
            }
        });


        Log.d(TAG, "onBindViewHolder: Chord" + videoInfo.toString());
    }

    @Override
    public int getItemCount() {
        return videoInfoList.size();
    }
}
