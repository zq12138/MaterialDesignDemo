package com.example.admin.materialdesigndemo.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.materialdesigndemo.R;
import com.example.admin.materialdesigndemo.util.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zq on 2017/9/15.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    List<String> images;
//    @BindView(R.id.toolbar)
//    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mInflater = inflater.inflate(R.layout.home_frament_layout, null);
        unbinder = ButterKnife.bind(this, mInflater);
//        getBaseActivity().setSupportActionBar(toolbar);
        initBanner();
        bannerListener();
//        Dialog dialog;
//        dialog.setContentView();
        return mInflater;
    }

    private void bannerListener() {
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getActivity(), position + "-", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initBanner() {
        images = new ArrayList<>();
        images.add("http://img1.imgtn.bdimg.com/it/u=2396808201,570250618&fm=27&gp=0.jpg");
        images.add("http://img4.imgtn.bdimg.com/it/u=1291731120,462254980&fm=27&gp=0.jpg");
        images.add("http://img1.imgtn.bdimg.com/it/u=307312259,39853346&fm=27&gp=0.jpg");
        banner.setImages(images).setImageLoader(new GlideImageLoader()).start();
    }


    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
