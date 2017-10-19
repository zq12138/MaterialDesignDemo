package com.example.admin.materialdesigndemo.behavior;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 14537 on 2017/10/11.
 */

public class ImageViewBehaviors extends CoordinatorLayout.Behavior<ImageView> {

    float alpha, scaleY;
    float height, width;

    public ImageViewBehaviors(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
        return dependency instanceof AppBarLayout;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, final ImageView child, final View dependency) {


        if (dependency.getY() >= -40) {
            alpha = 255 * dependency.getY() / -55;
            scaleY = 1 * dependency.getY() / -55;
            child.getBackground().setAlpha(255 - (int) alpha);
            child.setScaleY(1 - scaleY);
            child.setScaleX(1 - scaleY);
        } else {
            child.setScaleY(0);
            child.setScaleX(0);
            child.getBackground().setAlpha(0);
        }

        return true;
    }
}
