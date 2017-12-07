package com.zhaoxuan.accessibilitydemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;

import com.zhaoxuan.accessibilitydemo.R;
import com.zhaoxuan.accessibilitydemo.widget.paint.DrawingCanvas;
import com.zhaoxuan.accessibilitydemo.widget.paint.PaintBox;

/**
 * Created by lizhaoxuan on 2017/11/27.
 */

public class CustomerButton extends android.support.v7.widget.AppCompatButton {

    private String text;
    private int textColor;
    private int textSize;
    private DrawingCanvas localDrawingCanvas;

    public CustomerButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomerButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomerButton);
        text = a.getString(R.styleable.CustomerButton_str);
        textColor = a.getColor(R.styleable.CustomerButton_android_textColor, Color.BLACK);
        textSize = a.getDimensionPixelSize(R.styleable.CustomerButton_android_textSize, 42);
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //取得View的长宽信息，因为每一次View的载入长款
        float width = this.getWidth();
        float height = this.getHeight();
        /**
         * 因为界面有一定的刷新率，每一次刷新都会调用onDraw方法
         * 所以为了效率和性能考虑，需要做一些判断避免重复判断
         */
        if (localDrawingCanvas == null) {
            localDrawingCanvas = DrawingCanvas.instance(width, height);
            PaintBox.drawTextCenter(localDrawingCanvas, text, textColor, textSize);
        }

        canvas.drawBitmap(localDrawingCanvas.getOutput(), 0, 0, null);
    }


}
