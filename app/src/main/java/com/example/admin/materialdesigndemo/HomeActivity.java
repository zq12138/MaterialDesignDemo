package com.example.admin.materialdesigndemo;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.materialdesigndemo.fragment.HomeFragment;
import com.example.admin.materialdesigndemo.fragment.ListFragment;
import com.example.admin.materialdesigndemo.fragment.MoreFragment;
import com.example.admin.materialdesigndemo.fragment.PersonFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.roughike.bottombar.TabSelectionInterceptor;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zq on 2017/9/14.
 */

public class HomeActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    HomeFragment homeFragment;
    ListFragment listFragment;
    MoreFragment moreFragment;
    PersonFragment personFragment;


    @BindView(R.id.bottomBar)
    BottomBar bottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState != null) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            for (Fragment f : fragments) {
                if (f instanceof HomeFragment) {
                    homeFragment = (HomeFragment) f;
                } else if (f instanceof ListFragment) {
                    listFragment = (ListFragment) f;
                } else if (f instanceof MoreFragment) {
                    moreFragment = (MoreFragment) f;
                } else if (f instanceof PersonFragment) {
                    personFragment = (PersonFragment) f;
                }
            }
        }
        initView();

    }

    private void initView() {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        switchToHomePageFragment();
                        break;
                    case R.id.tab_list:
                        switchToListPageFragment();
                        break;
                    case R.id.tab_person:
                        switchToMorePageFragment();
                        break;
                    case R.id.tab_more:
                        switchToPersonPageFragment();
                        break;

                }

            }
        });

        bottomBar.setTabSelectionInterceptor(new TabSelectionInterceptor() {
            @Override
            public boolean shouldInterceptTabSelection(@IdRes int oldTabId, @IdRes int newTabId) {
                return false;
            }
        });
    }

    private void switchToHomePageFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        if (homeFragment != null) {
            fragmentTransaction.show(homeFragment);
        } else {
            homeFragment = new HomeFragment();
            fragmentTransaction.add(R.id.frame_layout, homeFragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void switchToListPageFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        if (listFragment != null) {
            fragmentTransaction.show(listFragment);
        } else {
            listFragment = new ListFragment();
            fragmentTransaction.add(R.id.frame_layout, listFragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void switchToPersonPageFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        if (personFragment != null) {
            fragmentTransaction.show(personFragment);
        } else {
            personFragment = new PersonFragment();
            fragmentTransaction.add(R.id.frame_layout, personFragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void switchToMorePageFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        if (moreFragment != null) {
            fragmentTransaction.show(moreFragment);
        } else {
            moreFragment = new MoreFragment();
            fragmentTransaction.add(R.id.frame_layout, moreFragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);
        }

        if (listFragment != null) {
            fragmentTransaction.hide(listFragment);
        }

        if (moreFragment != null) {
            fragmentTransaction.hide(moreFragment);
        }

        if (personFragment != null) {
            fragmentTransaction.hide(personFragment);
        }

    }


}
