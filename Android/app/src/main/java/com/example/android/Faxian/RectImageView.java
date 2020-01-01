package com.example.android.Faxian;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class RectImageView extends androidx.appcompat.widget.AppCompatImageView {

    public RectImageView(Context context) {
        this(context, null);
    }

    public RectImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setScaleType(ScaleType.FIT_XY);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        // 设置大小为宽度的三分之二
        int halfWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width / 3 * 2, widthMode);
        super.onMeasure(widthMeasureSpec, halfWidthMeasureSpec);
    }
}
