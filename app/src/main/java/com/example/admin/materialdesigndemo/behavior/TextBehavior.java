package com.example.admin.materialdesigndemo.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 14537 on 2017/10/10.
 */

public class TextBehavior extends CoordinatorLayout.Behavior<TextView> {

    private int mFrameMaxHeight = 100;
    private int mStartY;
    private float textSize;

    public TextBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        textSize = 18 * dependency.getY() / -55;
        child.setTextSize(textSize);
        return true;
    }
}
