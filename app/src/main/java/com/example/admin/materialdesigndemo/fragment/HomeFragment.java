package com.example.admin.materialdesigndemo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.materialdesigndemo.R;
import com.example.admin.materialdesigndemo.fragment.adapter.ProjectAdapter;
import com.example.admin.materialdesigndemo.util.DataUtil;
import com.example.admin.materialdesigndemo.util.GlideImageLoader;
import com.example.admin.materialdesigndemo.widget.RecyclerViewTouch;
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
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    LinearLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mInflater = inflater.inflate(R.layout.home_frament_layout, null);
        unbinder = ButterKnife.bind(this, mInflater);
//        getBaseActivity().setSupportActionBar(toolbar);
        initBanner();
        bannerListener();
        initSwipeRefresh();
        initRecycler();

        return mInflater;

    }

    private void initSwipeRefresh() {
        swipeRefresh.setProgressBackgroundColorSchemeResource(android.R.color.white);
        // 设置下拉进度的主题颜色
        swipeRefresh.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        DataUtil.getListData().set(0, "我是天才");
                        projectAdapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                }, 1500);
            }
        });
    }

    ProjectAdapter projectAdapter;

    private void initRecycler() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recycler.setHasFixedSize(true);
        //创建并设置Adapter
        projectAdapter = new ProjectAdapter(DataUtil.getListData());
        recycler.setAdapter(projectAdapter);
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
