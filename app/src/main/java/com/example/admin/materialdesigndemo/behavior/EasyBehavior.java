package com.example.admin.materialdesigndemo.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 14537 on 2017/10/10.
 */

public class EasyBehavior extends CoordinatorLayout.Behavior<TextView> {


    public EasyBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Button;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        child.setX(dependency.getX()+200);
        child.setY(dependency.getY()+200);
        child.setText(dependency.getX() + "   " + dependency.getY());
        return true;
    }
}
