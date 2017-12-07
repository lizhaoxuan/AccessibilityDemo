package com.zhaoxuan.accessibilitydemo.widget.paint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.Log;

/**
 * Created by lizhaoxuan on 2017/11/27.
 */

public class PaintBox {

    /**
     * 画圆角矩形
     *
     * @param canvas 画布
     * @param color  填充颜色
     * @param alpha  透明度
     */
    public static void drawRoundRect(DrawingCanvas canvas, int color, int alpha) {

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(color);
        paint.setAlpha(alpha);
        canvas.drawRoundRect(canvas.getRectF(), 20, 20, paint);


    }

    /**
     * 画圆角矩形
     *
     * @param canvas 画布
     * @param color  填充颜色
     * @param alpha  透明度
     * @param border 带边框
     */
    public static void drawRoundRect(DrawingCanvas canvas, int color, int alpha, boolean border) {
        if (border) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(color);
            paint.setAlpha(30);
            canvas.drawRoundRect(canvas.getRectF(), 20, 20, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setAlpha(70);
            paint.setStrokeWidth(4);
            canvas.drawRoundRect(canvas.getRectF(), 20, 20, paint);
        } else {
            drawRoundRect(canvas, color, alpha);
        }


    }

    /**
     * 填充颜色
     *
     * @param canvas
     * @param color
     */
    public static void drawColor(DrawingCanvas canvas, int color) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(color);
        canvas.drawPaint(paint);
    }


    /**
     * 写字在View正中间
     *
     * @param canvas 画布
     * @param text   文字
     * @param color  文字颜色
     * @param size   文字大小
     */
    public static void drawTextCenter(DrawingCanvas canvas, String text, int color, int size) {
        //创建画笔
        TextPaint pp = new TextPaint();
        pp.setAntiAlias(true);
        pp.setColor(color);
        pp.setStrokeWidth(3);
        pp.setTextSize(size);
        pp.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt fontMetrics = pp.getFontMetricsInt();
        Log.d("TAG11", fontMetrics.top + "  " + fontMetrics.bottom);

        float vertical = canvas.getRectF().top + (canvas.getRectF().bottom - canvas.getRectF().top - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        canvas.drawText(text, canvas.getRectF().centerX(), vertical, pp);
    }

    /**
     * 写字在View正中间
     *
     * @param canvas 画布
     * @param text   文字
     * @param color  文字颜色
     * @param size   文字大小
     */
    public static void drawTextCenter(Canvas canvas, String text, int color, int size) {
        Rect rect = new Rect();
        //创建画笔
        Paint pp = new Paint();
        pp.setAntiAlias(true);
        pp.setColor(color);
        pp.setStrokeWidth(3);
        pp.setTextSize(size);
        pp.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt fontMetrics = pp.getFontMetricsInt();

        pp.getTextBounds(text, 0, text.length(), rect);

        float vertical = rect.top + (rect.bottom - rect.top - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        canvas.drawText(text, rect.centerX(), vertical, pp);
    }

    public static DrawingCanvas drawTextCenter(String text, int color, int size) {
        Rect rect = new Rect();
        //创建画笔
        Paint pp = new Paint();
        pp.setAntiAlias(true);
        pp.setColor(color);
        pp.setStrokeWidth(3);
        pp.setTextSize(size);
        pp.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt fontMetrics = pp.getFontMetricsInt();

        pp.getTextBounds(text, 0, text.length(), rect);

        DrawingCanvas localDrawingCanvas = DrawingCanvas.instance(rect.width(), rect.height());

        float vertical = localDrawingCanvas.getRectF().top + (localDrawingCanvas.getRectF().bottom - localDrawingCanvas.getRectF().top - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        localDrawingCanvas.drawText(text, rect.centerX(), vertical, pp);
        return localDrawingCanvas;
    }


}
