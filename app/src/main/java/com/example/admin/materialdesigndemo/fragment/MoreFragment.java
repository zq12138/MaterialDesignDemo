package com.example.admin.materialdesigndemo.fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.materialdesigndemo.R;
import com.example.admin.materialdesigndemo.retrofit.RequestCommand;
import com.example.admin.materialdesigndemo.retrofit.bean.ImageCodeBean;
import com.example.admin.materialdesigndemo.retrofit.callback.DialogCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;

/**
 * Created by zq on 2017/9/15.
 */

public class MoreFragment extends BaseFragment {


    @BindView(R.id.img)
    ImageView img;
    Unbinder unbinder;
    @BindView(R.id.btn)
    Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mInflater = inflater.inflate(R.layout.more_frament_layout, null);
        unbinder = ButterKnife.bind(this, mInflater);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestCommand.login(new LoginCallback(MoreFragment.this));
            }
        });
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    v.setY(event.getRawY() - v.getHeight() / 2);
                    v.setX(event.getRawX() - v.getWidth() / 2);
                }
                return false;
            }
        });
        return mInflater;
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
