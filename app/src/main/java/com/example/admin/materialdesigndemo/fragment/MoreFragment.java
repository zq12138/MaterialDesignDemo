package com.example.admin.materialdesigndemo.fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.materialdesigndemo.R;
import com.example.admin.materialdesigndemo.data.CardVo;
import com.example.admin.materialdesigndemo.fragment.adapter.RecyclerAdapter;
import com.example.admin.materialdesigndemo.retrofit.RequestCommand;
import com.example.admin.materialdesigndemo.retrofit.bean.ImageCodeBean;
import com.example.admin.materialdesigndemo.retrofit.callback.DialogCallback;
import com.example.admin.materialdesigndemo.util.DataUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;

/**
 * Created by zq on 2017/9/15.动画
 */

public class MoreFragment extends BaseFragment {

    @BindView(R.id.app_bar)
    AppBarLayout appBar;
//    @BindView(R.id.collapsingtoolbarlayout)
//    CollapsingToolbarLayout collapsingtoolbarlayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private CollapsingToolbarLayoutState state;

    private enum CollapsingToolbarLayoutState {EXPANDED, COLLAPSED, INTERNEDIATE}

    @BindView(R.id.img)
    ImageView img;
    Unbinder unbinder;

    private CardVo[] cardVos = {new CardVo(R.drawable.orange, "orange"),
            new CardVo(R.drawable.cherry, "cherry"),
            new CardVo(R.drawable.grape, "grape"),
            new CardVo(R.drawable.mango, "mango"),
            new CardVo(R.drawable.peay, "peay"),
            new CardVo(R.drawable.pineapple, "pineapple"),
            new CardVo(R.drawable.orange, "orange"),
            new CardVo(R.drawable.cherry, "cherry"),
            new CardVo(R.drawable.grape, "grape"),
            new CardVo(R.drawable.mango, "mango"),
            new CardVo(R.drawable.peay, "peay"),
            new CardVo(R.drawable.pineapple, "pineapple")
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mInflater = inflater.inflate(R.layout.more_frament_layout, null);
        unbinder = ButterKnife.bind(this, mInflater);
        //设置导航图标要在setSupportActionBar方法之后
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.reset_psd);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestCommand.login(new LoginCallback(MoreFragment.this));
            }
        });

        initRecycler();
        return mInflater;
    }

    private void initRecycler() {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recycler.setLayoutManager(layoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recycler.setHasFixedSize(true);
        //创建并设置Adapter
        RecyclerAdapter adapter = new RecyclerAdapter(cardVos);
        recycler.setAdapter(adapter);
    }

    private static class LoginCallback extends DialogCallback<ImageCodeBean, MoreFragment> {
        public LoginCallback(MoreFragment requestView) {
            super(requestView);
        }

        @Override
        protected void onResponseSuccess(ImageCodeBean imageCodeBean, Call<ImageCodeBean> call) {
            byte[] image = Base64.decode(imageCodeBean.getBody().getIndentify(), Base64.DEFAULT);
            getAttachTarget().img.setImageBitmap(BitmapFactory.decodeByteArray(image, 0, image.length));
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
