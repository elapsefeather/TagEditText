package com.elapsefeather.tagedittext;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TextReplacementSpan extends ReplacementSpan {
    private final String mTag;
    private final String mLabel;
    private int mColor = 0xff007aff;

    public TextReplacementSpan(String tag, String label) {
        super();

        mTag = tag;
        mLabel = label;
    }

    public TextReplacementSpan(String tag, String label, Integer color) {
        super();

        mTag = tag;
        mLabel = label;
        if (color != null)
            mColor = color;
    }

    public int getCount() {
        return mTag.length();
    }

    @Override
    public void updateMeasureState(TextPaint p) {
        super.updateMeasureState(p);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
    }

    @Override
    public int getSize(@NonNull Paint paint, CharSequence text, int start, int end,
                       @Nullable Paint.FontMetricsInt fm) {
        return Math.round(paint.measureText(mLabel));
    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x,
                     int top, int y, int bottom, @NonNull Paint paint) {
        paint.setColor(mColor);
        canvas.drawText(mLabel, x, y, paint);
    }
}
