package com.example.admin.materialdesigndemo.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 14537 on 2017/10/12.
 */

public class CoordinatorTouch extends CoordinatorLayout {
    public CoordinatorTouch(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CoordinatorTouch(Context context) {
        super(context);
    }

    public CoordinatorTouch(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(ev);

    }
}
