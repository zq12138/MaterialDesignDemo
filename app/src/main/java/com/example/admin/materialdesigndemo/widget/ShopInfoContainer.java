package com.example.admin.materialdesigndemo.widget;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.materialdesigndemo.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;

public class ShopInfoContainer extends RelativeLayout {


    public TextView shop_name, shop_sum, shop_type, shop_send;
    private ImageView shop_arrow, iv_pin;
    private SimpleDraweeView iv_shop;

    public ShopInfoContainer(Context context) {
        super(context);
    }

    public ShopInfoContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        View view = inflate(context, R.layout.view_shopinfo, this);



    }


    public void setWgAlpha(float alpha) {
        shop_sum.setAlpha(alpha);
        shop_arrow.setAlpha(alpha);
        shop_sum.setAlpha(alpha);
        shop_type.setAlpha(alpha);
        shop_send.setAlpha(alpha);
        iv_shop.setAlpha(alpha);
        iv_pin.setAlpha(alpha);
    }
}
