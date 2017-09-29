package com.example.admin.materialdesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.materialdesigndemo.R;
import com.example.admin.materialdesigndemo.ViewPagerAdapter;
import com.example.admin.materialdesigndemo.fragment.project.CreditorFragment;
import com.example.admin.materialdesigndemo.fragment.project.FundFragment;
import com.example.admin.materialdesigndemo.fragment.project.ProjectFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zq on 2017/9/15.项目
 */

public class ListFragment extends BaseFragment {

    List<String> stringList;
    List<Fragment> fragmentList;

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    Unbinder unbinder;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mInflater = inflater.inflate(R.layout.list_frament_layout, null);
        unbinder = ButterKnife.bind(this, mInflater);
        toolbar.setTitle("Title");
        toolbar.setSubtitle("SubTitle");
        toolbar.setLogo(R.mipmap.ic_launcher);

        //设置导航图标要在setSupportActionBar方法之后

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationIcon(R.mipmap.rb_more_unselect);
        initDate();
        initView();
        setHasOptionsMenu(true);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        Toast.makeText(getActivity(),"action_search", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_notifications:
                        Toast.makeText(getActivity(),"action_notifications", Toast.LENGTH_LONG).show();

                        break;
                    case R.id.action_settings:
                        Toast.makeText(getActivity(),"action_settings", Toast.LENGTH_LONG).show();

                        break;
                }

                return true;
            }
        });

        return mInflater;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.base_toolbar_menu, menu);
    }

    private void initView() {
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
        fragmentList.add(new CreditorFragment());
        fragmentList.add(new FundFragment());
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
