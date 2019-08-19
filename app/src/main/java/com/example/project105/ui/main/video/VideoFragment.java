package com.example.project105.ui.main.video;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.project105.R;
import com.example.project105.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VideoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends BaseFragment implements VideoView {

    private static final String TAG = "VideoFragment";

    @BindView(R.id.book_list_rec)
    RecyclerView bookListRec;

    @BindView(R.id.study_fragment_refresh)
    SwipeRefreshLayout studyFragmentRefresh;

    @Inject
    VideoPresenter<VideoView> presenter;

    private VideoInfoAdapter adapter;

    private OnFragmentInteractionListener mListener;

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            presenter.refresh(" " + -1);
            studyFragmentRefresh.setRefreshing(false);
        }
    };

    public VideoFragment() {
    }

    public static VideoFragment newInstance() {
        VideoFragment fragment = new VideoFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        unbinder = ButterKnife.bind(this, view);

        // 绑定presenter
        presenter.onAttach(this);

        // 为RecyclerView添加Manager设置两列，设置适配器
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        bookListRec.setLayoutManager(layoutManager);

        // 设置刷新的颜色
        studyFragmentRefresh.setColorSchemeResources(R.color.colorPrimary);
        studyFragmentRefresh.setOnRefreshListener(refreshListener);

        presenter.refresh(" " + (-1));

        Log.d(TAG, "onCreateView: after refresh");

        return view;
    }

    public void setAdapter(List<VideoInfo> list) {
        this.adapter = new VideoInfoAdapter(list);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void showVideoList(List<VideoInfo> videoInfoList) {
        adapter = new VideoInfoAdapter(videoInfoList);
        bookListRec.setAdapter(adapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
