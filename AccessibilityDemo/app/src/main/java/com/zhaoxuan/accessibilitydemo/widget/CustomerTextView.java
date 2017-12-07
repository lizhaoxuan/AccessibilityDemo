package com.zhaoxuan.accessibilitydemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.zhaoxuan.accessibilitydemo.R;
import com.zhaoxuan.accessibilitydemo.widget.paint.DrawingCanvas;
import com.zhaoxuan.accessibilitydemo.widget.paint.PaintBox;

/**
 * Created by lizhaoxuan on 2017/11/27.
 */

public class CustomerTextView extends android.support.v7.widget.AppCompatTextView {

    private String text;
    private int textColor;
    private int textSize;
    private DrawingCanvas localDrawingCanvas;

    public CustomerTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomerTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomerTextView);
        text = a.getString(R.styleable.CustomerTextView_android_text);
        textColor = a.getColor(R.styleable.CustomerTextView_android_textColor, Color.BLACK);
        textSize = a.getDimensionPixelSize(R.styleable.CustomerTextView_android_textSize, 42);
        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //取得View的长宽信息，因为每一次View的载入长款
        float width = this.getWidth();
        float height = this.getHeight();

        if (localDrawingCanvas == null) {
            localDrawingCanvas = DrawingCanvas.instance(width, height);
            PaintBox.drawTextCenter(localDrawingCanvas, text, textColor, textSize);
        }

        canvas.drawBitmap(localDrawingCanvas.getOutput(), 0, 0, null);
    }
}
