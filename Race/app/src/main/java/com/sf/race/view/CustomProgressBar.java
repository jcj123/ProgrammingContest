package com.sf.race.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.sf.race.R;

/**
 * Created by jcj on 2017/12/15.
 */
public class CustomProgressBar extends View {

    private Paint mBgtPaint;//底部背景画笔
    private Paint mProgressPaint;//progress画笔
    private Paint mTextPaint;
    private int startX;//起始X坐标，保持不变
    private int endX;//终点坐标,保持不变
    private int currentX;//当前坐标,progress换算而来，不断增大

    private int mProgressBgHeight = 40;
    private int mProgressHeight = 50;
    private int mProgressBgColor = Color.BLACK;
    private int mProgressColor = Color.BLUE;

    public CustomProgressBar(Context context) {
        this(context, null);
    }

    public CustomProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public CustomProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.myProgressBar, defStyleAttr, 0);

        mProgressBgHeight = a.getInteger(R.styleable.myProgressBar_progress_background_height, mProgressBgHeight);
        mProgressHeight = a.getInteger(R.styleable.myProgressBar_progress_height, mProgressHeight);
        mProgressBgColor = a.getColor(R.styleable.myProgressBar_progress_background_color, mProgressBgColor);
        mProgressColor = a.getColor(R.styleable.myProgressBar_progress_color, mProgressColor);

        a.recycle();

        init();
    }


    private void init() {

        //初始化画笔
        mBgtPaint = new Paint();
        mBgtPaint.setAntiAlias(true);//抗锯齿
        mBgtPaint.setStyle(Paint.Style.STROKE);
        //注意：这是笔尖样式的属性，Paint.Cap.ROUND设置笔尖为圆形，默认方形，
        mBgtPaint.setStrokeCap(Paint.Cap.ROUND);
        mBgtPaint.setColor(mProgressBgColor);
//        mBgtPaint.setColor(Color.parseColor("#1F1F26"));//设置画笔颜色，这里是深灰色
        mBgtPaint.setStrokeWidth(50);

        mTextPaint = new Paint();
        mTextPaint.setTextSize(30);
        mTextPaint.setColor(Color.WHITE);

        mProgressPaint = new Paint();
        mProgressPaint.setAntiAlias(true);
        mProgressPaint.setStyle(Paint.Style.STROKE);
        mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
        mProgressPaint.setColor(mProgressColor);
//        mProgressPaint.setColor(Color.parseColor("#54FC00"));
        mProgressPaint.setStrokeWidth(50);//这里的线条宽度比背景线条窄一些。

    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        //这里根据屏幕的宽高获取坐标，可以设置成自定义属性，让用户设置
        startX = getWidth() / 2 - getWidth() / 3;
        endX = getWidth() / 2 + getWidth() / 3;
        currentX = startX;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制底部背景线条(深灰色，区别于View背景色)
        canvas.drawLine(startX, getHeight() / 2, endX,
                getHeight() / 2, mBgtPaint);

        //绘制当前的progress
        canvas.drawLine(startX - 5, getHeight() / 2, currentX,
                getHeight() / 2, mProgressPaint);

        //绘制进度显示的字
        if (!TextUtils.isEmpty(textProgress)) {
            canvas.drawText(textProgress, startX + 35, getHeight() / 2 + 12, mTextPaint);
        }
    }

    private String textProgress;

    public void setTextProgress(String textProgress) {
        this.textProgress = textProgress;
    }

    //更新进度
    public void updateProgress(int progress) {

        //这里progress的长度分成100个单位，再计算坐标，其实progress可以是实时的下载进度，
        //计算下载量百分比，然后再计算坐标，会相对精确
        if (progress <= 100) {
            currentX = startX + (int) ((progress * 1.0) / 100 * (endX - startX));
            invalidate();//重新绘制才能生效
        }
    }
}

