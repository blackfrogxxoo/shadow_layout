package me.wxc.shadowlayout;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ShadowLayout extends FrameLayout {
    private static final String TAG = "ShadowLayout";
    private float aFloat = 1.8f;
    private final Paint paint;
    private RectF rect;
    private int blurRadius = 80;
    private int rectRadius = 0;
    private float translateX, translateY;
    private float shadowAlpha = 0.4f;

    public ShadowLayout(@NonNull Context context) {
        super(context);
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setClipChildren(false);
        setClipToPadding(false);
        setWillNotDraw(false);
        paint = new Paint();
        paint.setColor(Color.parseColor("#000000"));
        paint.setStyle(Paint.Style.FILL);
        paint.setMaskFilter(new BlurMaskFilter(blurRadius, BlurMaskFilter.Blur.SOLID));
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setAlpha((int) (255 * shadowAlpha));
        canvas.save();
        if (rect == null) {
            rect = new RectF();
        }
        canvas.translate(translateX, translateY);
        rect.left = getPaddingLeft() * aFloat;
        rect.top = getPaddingTop() * aFloat;
        rect.right = getMeasuredWidth() - getPaddingRight() * aFloat;
        rect.bottom = getMeasuredHeight() - getPaddingBottom() * aFloat;
        Log.i(TAG, "onDraw: " + rect);
        canvas.drawRoundRect(rect, rectRadius, rectRadius, paint);
        canvas.restore();
        Log.i(TAG, "onDraw: 1");
        super.onDraw(canvas);
        Log.i(TAG, "onDraw: 2");
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Log.i(TAG, "dispatchDraw: 1");
        super.dispatchDraw(canvas);
        Log.i(TAG, "dispatchDraw: 2");
    }

    public void setRectRadius(int radius) {
        this.rectRadius = radius;
        invalidate();
    }

    public void setBlurRadius(int blurRadius) {
        this.blurRadius = blurRadius;
        paint.setMaskFilter(new BlurMaskFilter(blurRadius, BlurMaskFilter.Blur.NORMAL));
        invalidate();
    }

    public void setFloat(float aF) {
        this.aFloat = aF;
        invalidate();
    }

    public void setTranslateX(float x) {
        translateX = x;
        invalidate();
    }

    public void setTranslateY(float y) {
        translateY = y;
        invalidate();
    }

    public void setShadowAlpha(float shadowAlpha) {
        this.shadowAlpha = shadowAlpha;
        invalidate();
    }
}
