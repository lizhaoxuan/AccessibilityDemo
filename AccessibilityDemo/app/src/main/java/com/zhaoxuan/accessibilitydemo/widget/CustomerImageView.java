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

public class CustomerImageView extends android.support.v7.widget.AppCompatImageView {

    private String text;
    private int textColor;
    private int textSize;
    private DrawingCanvas localDrawingCanvas;

    public CustomerImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomerImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomerImageView);
        text = a.getString(R.styleable.CustomerImageView_android_text);
        textColor = a.getColor(R.styleable.CustomerImageView_android_textColor, Color.BLACK);
        textSize = a.getDimensionPixelSize(R.styleable.CustomerImageView_android_textSize, 42);
        a.recycle();
    }

    public String getText() {
        return text;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setText(String text) {
        this.text = text;
        setImageBitmap(PaintBox.drawTextCenter(text, textColor, textSize).getOutput());
    }
}
