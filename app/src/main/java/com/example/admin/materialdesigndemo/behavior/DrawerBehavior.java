package com.example.admin.materialdesigndemo.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 14537 on 2017/10/10.
 */

public class DrawerBehavior extends CoordinatorLayout.Behavior<TextView> {

    private int mFrameMaxHeight = 100;
    private int mStartY;

    public DrawerBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        if (mStartY == 0) {
            mStartY = (int) dependency.getY();
        }
        float percent = dependency.getY() / mStartY;
        child.setY(child.getHeight() * (1 - percent) - child.getHeight());
        return true;
    }
}
