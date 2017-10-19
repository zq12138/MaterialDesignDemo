package com.example.admin.materialdesigndemo.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.example.admin.materialdesigndemo.R;
import com.example.admin.materialdesigndemo.util.ViewUtils;

import static com.example.admin.materialdesigndemo.R.*;

/**
 * Created by 14537 on 2017/10/18.
 */

public class AppBarBehavior extends AppBarLayout.Behavior {
    public static int cutExpHeight = -1;
    private static int cutMaxHeight = -1;
    private View scroll_container;
    private boolean isPositive, fromFling;

    public Context mContext;

    public AppBarBehavior() {
    }

    public AppBarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mContext = context;
        setDragCallback(new DragCallback() {
            @Override
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return false;
            }
        });
    }


    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, AppBarLayout abl, int layoutDirection) {
        boolean isChild = super.onLayoutChild(parent, abl, layoutDirection);
        if (cutExpHeight <= 0) {
            View cut = parent.findViewById(id.ll_cut);
            cutExpHeight = (int) (cut.getHeight() - mContext.getResources().getDimension(R.dimen.card_span));
            cutMaxHeight = ViewUtils.dip2px(mContext, 30) + cutExpHeight;
            scroll_container = parent.findViewById(R.id.scroll_container);
        }
        return isChild;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed) {

        if (scroll_container == null) {
            return;
        }
        isPositive = dy > 0;
        float cty = scroll_container.getTranslationY();
        if (dy > 0 && cty > 0 && child.getTop() == 0) {
            cty -= dy;
            scroll_container.setTranslationY(cty < 0 ? 0 : cty);
            consumed[1] = dy;
        } else {
            super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        }

    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if (scroll_container == null) {
            return;
        }
        if (dxConsumed == 0 && dxUnconsumed < 0 && child.getTop() == 0) {
            float cty = scroll_container.getTranslationY();
            cty = cty - dyUnconsumed > cutMaxHeight ? cutMaxHeight : cty - dyUnconsumed;
            scroll_container.setTranslationY(cty);
            return;
        }
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }
}
