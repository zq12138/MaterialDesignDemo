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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    List<String> stringList;
    List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        fragmentList = new ArrayList<>();
        fragmentList.add(new BaseFragment());
        fragmentList.add(new BaseFragment());
        fragmentList.add(new BaseFragment());
        stringList = new ArrayList<>();
        stringList.add("1111");
        stringList.add("2222");
        stringList.add("3333");
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragmentList,stringList );
        viewPager.setAdapter(vpAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void snackShow(FloatingActionButton fAButton) {
        Snackbar.make(fAButton, "-=--", Snackbar.LENGTH_SHORT).setAction("000", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }).show();
    }
}
