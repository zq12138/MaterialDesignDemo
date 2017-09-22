package com.example.admin.materialdesigndemo.behavior;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.admin.materialdesigndemo.R;


/**
 * Created by zq on 2017/9/21.
 */

public class ToolbarAlphaBehavior extends CoordinatorLayout.Behavior<Toolbar> {


    int startOffset = 0;
    int endOffset = 0;


    Context context;

    public ToolbarAlphaBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public boolean onNestedFling(final CoordinatorLayout coordinatorLayout, final Toolbar child, final View target, final float velocityX, final float velocityY, final boolean consumed) {
        final int scrollY = target.getScrollY();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (target.getScrollY() == scrollY) {
                    scrollY(child, target);
                } else {
                    scrollY(child, target);
                    onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
                }
            }
        }, 30);
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        scrollY(child, target);
    }

    private void scrollY(Toolbar child, View target) {
        startOffset = 0;
        endOffset = context.getResources().getDimensionPixelOffset(R.dimen.header_height) - child.getHeight();
        if (target.getScrollY() <= startOffset) {
            child.getBackground().setAlpha(0);
        } else if (target.getScrollY() > startOffset && target.getScrollY() < endOffset) {
            float percent = (float) (target.getScrollY() - startOffset) / endOffset;
            int alpha = Math.round(percent * 255);
            child.getBackground().setAlpha(alpha);
        } else if (target.getScrollY() >= endOffset) {
            child.getBackground().setAlpha(255);
        }
    }
}
