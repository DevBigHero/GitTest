package com.example.bighero;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by bighero on 2017/4/19.
 */

public class PathView extends View {

    Paint mPaint;

    int width;
    int height;

    int mRippleWidth;
    int mRippleHeight;

    int offset;

    public PathView(Context context) {
        this(context, null);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint(context);
    }

    /**
     * lineTo   从当前点移动到（x,y）并且画出路径
     * moveTo   将当前点移动到（x，y）   不画路径    会影响下次操作，不会影响上一次操作
     * setLastPoint   将上一次的操作路径的终点移动到(x,y)   会影响下次操作，也会影响上一次操作
     * close()  ,闭合起点和终点
     * <p>
     * quadTo()     二阶贝塞尔曲线
     * cubicTo()    三阶贝塞尔曲线
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path mPath = new Path();
        mPath.moveTo(-mRippleWidth+offset, mRippleHeight);
        mPath.quadTo(-mRippleWidth*3/4+offset,mRippleHeight+60,-mRippleWidth/2+offset,mRippleHeight);
        mPath.quadTo(-mRippleWidth/4+offset,mRippleHeight-60,0+offset,mRippleHeight);
        mPath.quadTo(mRippleWidth/4+offset,mRippleHeight+60,mRippleWidth/2+offset,mRippleHeight);
        mPath.quadTo(mRippleWidth*3/4+offset,mRippleHeight-60,mRippleWidth+offset,mRippleHeight);
        mPath.lineTo(width,height);
        mPath.lineTo(0,height);
        mPath.close();
        canvas.drawPath(mPath,mPaint);


    }

    public void drawRipple(){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,mRippleWidth);
        valueAnimator.setDuration(1000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                offset = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.start();
    }

    private void initPaint(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#40cde9"));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10);
        width = ScreenUtils.getScreenWidth(context);
        height = ScreenUtils.getScreenHeight(context);
        mRippleWidth = width;
        mRippleHeight = height / 2;
        drawRipple();
    }
}
