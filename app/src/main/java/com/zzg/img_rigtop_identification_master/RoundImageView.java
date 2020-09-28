package com.zzg.img_rigtop_identification_master;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author Zhangzhenguo
 * @create 2020/9/28
 * @Email 18311371235@163.com
 * @Describe
 */
public class RoundImageView extends androidx.appcompat.widget.AppCompatImageView {
    float width, height;

    public RoundImageView(@NonNull Context context) {
        this(context, null);
        init(context, null);
    }

    public RoundImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        init(context, attrs);
    }

    public RoundImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        //四个圆角
        path.moveTo(width - getPaddingRight(), 0 - getPaddingRight());

        path.lineTo(width - getPaddingRight() - 50, 0 - getPaddingRight());
        path.quadTo(width, 0 - getPaddingRight(), width - getPaddingRight(), 50 - getPaddingRight());

        path.lineTo(width - getPaddingRight(), height - 50);
        path.quadTo(width - getPaddingRight(), height, width - getPaddingRight() - 50, height - getPaddingRight());

        path.lineTo(50, height);
        path.quadTo(0, height, 0, height - 50);


        path.lineTo(0, 50);
        path.quadTo(0, 0, 50, 0);
        canvas.clipPath(path);

    }

}
