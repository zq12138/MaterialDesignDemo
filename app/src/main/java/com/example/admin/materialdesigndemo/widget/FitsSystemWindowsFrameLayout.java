package com.example.admin.materialdesigndemo.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;

/**
 * Created by zq on 2017/9/26.
 */

public class FitsSystemWindowsFrameLayout extends FrameLayout {

    private Rect windowInsets = new Rect();
    private Rect tempInsets = new Rect();

    public FitsSystemWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitsSystemWindowsFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FitsSystemWindowsFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FitsSystemWindowsFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        int childCount = getChildCount();
        for (int index = 0; index < childCount; index++)
            getChildAt(index).dispatchApplyWindowInsets(insets);

        return insets;
    }
}
