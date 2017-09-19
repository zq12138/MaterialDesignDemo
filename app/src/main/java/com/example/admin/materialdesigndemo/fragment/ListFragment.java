package com.example.admin.materialdesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.materialdesigndemo.R;
import com.example.admin.materialdesigndemo.ViewPagerAdapter;
import com.example.admin.materialdesigndemo.fragment.project.ProjectFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zq on 2017/9/15.项目
 */

public class ListFragment extends Fragment {

    List<String> stringList;
    List<Fragment> fragmentList;

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mInflater = inflater.inflate(R.layout.list_frament_layout, null);
        unbinder = ButterKnife.bind(this, mInflater);
        initDate();
        initView();

        return mInflater;
    }

    private void initView() {
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        tablayout.addTab(tablayout.newTab().setText("Tab 1"));
        tablayout.addTab(tablayout.newTab().setText("Tab 2"));
        tablayout.addTab(tablayout.newTab().setText("Tab 3"));
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), fragmentList, stringList);
        viewPager.setAdapter(vpAdapter);
        tablayout.setupWithViewPager(viewPager);
    }

    private void initDate() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new ProjectFragment());
        fragmentList.add(new MoreFragment());
        fragmentList.add(new MoreFragment());
        stringList = new ArrayList<>();
        stringList.add("投资项目");
        stringList.add("债权转让");
        stringList.add("基金保险");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
