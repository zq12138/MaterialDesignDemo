package com.example.admin.materialdesigndemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by zq on 2017/9/14.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> stringList;

    public ViewPagerAdapter(FragmentManager fm,List<Fragment> fragmentList, List<String> stringList) {
        super(fm);
        this.stringList = stringList;
        this.fragmentList = fragmentList;
    }


    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }



    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }


}
