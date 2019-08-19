package com.example.project105.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.project105.R;
import com.example.project105.ui.base.BaseActivity;
import com.example.project105.ui.main.bulb.BulbFragment;
import com.example.project105.ui.main.discover.DiscoverFragment;
import com.example.project105.ui.main.me.MeFragment;
import com.example.project105.ui.main.video.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView, BulbFragment.OnFragmentInteractionListener
, VideoFragment.OnFragmentInteractionListener, DiscoverFragment.OnFragmentInteractionListener,
MeFragment.OnFragmentInteractionListener{

    private static final String TAG = "MainActivity";
    
    @BindView(R.id.nav_view)
    BottomNavigationView navigation;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.user_info_drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.main_toolbar)
    Toolbar mToolBar;

    @BindView(R.id.drawer_nav_view)
    NavigationView navView;

    private MenuItem menuItem;

    // 底部导航栏的监听器实例
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_bulb:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_video:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_discover:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_me:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(mToolBar);

        // 初始化适配器来初始化Viewpager
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(BulbFragment.newInstance("ChordNote","ChordNote"));
        adapter.addFragment(VideoFragment.newInstance());
        adapter.addFragment(DiscoverFragment.newInstance("ChordNote","ChordNote"));
        adapter.addFragment(MeFragment.newInstance(Long.valueOf(100)));

        // 给viewpager设置适配器并把首页设置在学习界面
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(2);
        navigation.setSelectedItemId(R.id.navigation_discover);

        // 给导航栏添加监听器监听点击事件
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // 给viewpager添加监听器处理事件
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        showToastText("onFragmentInteraction");
    }

}
