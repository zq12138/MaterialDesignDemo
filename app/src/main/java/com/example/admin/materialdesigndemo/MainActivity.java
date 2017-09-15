package com.example.admin.materialdesigndemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.admin.materialdesigndemo.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    List<String> stringList;
    List<Fragment> fragmentList;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDate();
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        tablayout.addTab(tablayout.newTab().setText("Tab 1"));
        tablayout.addTab(tablayout.newTab().setText("Tab 2"));
        tablayout.addTab(tablayout.newTab().setText("Tab 3"));
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList, stringList);
        viewPager.setAdapter(vpAdapter);
        tablayout.setupWithViewPager(viewPager);
    }

    private void initDate() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new HomeFragment());
        fragmentList.add(new HomeFragment());
        stringList = new ArrayList<>();
        stringList.add("1111");
        stringList.add("2222");
        stringList.add("3333");
    }

    private void snackShow(FloatingActionButton fAButton) {
        Snackbar.make(fAButton, "-=--", Snackbar.LENGTH_SHORT).setAction("000", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).show();
    }
}
