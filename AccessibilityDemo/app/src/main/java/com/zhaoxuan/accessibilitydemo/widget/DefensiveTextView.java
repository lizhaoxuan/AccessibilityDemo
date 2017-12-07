package com.zhaoxuan.accessibilitydemo.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by lizhaoxuan on 2017/12/4.
 */

public class DefensiveTextView extends android.support.v7.widget.AppCompatTextView {
    public DefensiveTextView(Context context) {
        super(context);
    }

    public DefensiveTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DefensiveTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags) {
//        super.findViewsWithText(outViews, searched, flags);
        outViews.clear();
        // or outViews.remove(this);
    }
}
