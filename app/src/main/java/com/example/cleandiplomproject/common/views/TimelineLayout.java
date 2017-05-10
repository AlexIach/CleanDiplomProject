package com.example.cleandiplomproject.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.cleandiplomproject.R;

/**
 * Created by aiachimov on 4/28/17.
 */

public class TimelineLayout extends LinearLayout {
    public TimelineLayout(final Context context) {
        this(context, null, 0);
    }

    public TimelineLayout(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimelineLayout(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.layout_timeline, this);
    }
}
