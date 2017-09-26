package com.example.admin.materialdesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.materialdesigndemo.R;

/**
 * Created by zq on 2017/9/15.
 */

public class MoreFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mInflater = inflater.inflate(R.layout.more_frament_layout, null);
//        StatusBarCompat.setStatusBarColor(getActivity(), getResources().getColor(R.color.colorPrimaryDark));
        return mInflater;
    }


}
