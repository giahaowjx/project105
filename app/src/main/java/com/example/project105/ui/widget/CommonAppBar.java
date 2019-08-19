package com.example.project105.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.project105.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommonAppBar extends FrameLayout {

    @BindView(R.id.back_btn)
    ImageButton backBtn;

    @BindView(R.id.more_service_btn)
    ImageButton moreServiceBtn;

    @BindView(R.id.appbar_title_text)
    TextView titleText;

    public CommonAppBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        LayoutInflater.from(context).inflate(R.layout.widget_appbar, this);

        ButterKnife.bind(this);


    }

    @OnClick(R.id.back_btn)
    public void onClickBackBtn(View view) {
        ((Activity) getContext()).finish();
    }

    @OnClick(R.id.more_service_btn)
    public void onClickMoreServiceBtn(View view) {

    }

    public void setTitleText(String title) {
        titleText.setText(title);
    }

}
