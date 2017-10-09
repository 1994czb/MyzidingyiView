package com.example.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/10/9.
 */

public class MyView extends View {
    private Paint paint;//画笔
    private int max;//最大值
    private int progress;//最小值
    private int color;//就是给他一个颜色 让它用来变色
    private RectF rectF;//用来圆弧用的

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    //初始化

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectF = new RectF();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);//设置圆环的宽度
        paint.setColor(Color.RED);//设置圆的颜色
        canvas.drawCircle(300, 300, 200, paint);//画圆
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15);
        rectF.set(100, 100, 500, 500);//设定范围
        //画圆弧   -90是起始的角度 因为x轴4方向是0度 所以用-90度 后一个参数是圆环的总角度 因为是用来变化的 360的时候刚好是一个圈
        //false是是否连接圆心 连接了的话就是扇形了 最后一个是paint
        canvas.drawArc(rectF, -90, ((float) progress / max) * 360, false, paint);
        paint.reset();//需要重置  是因为canvas绘制利用太多 颜色会加深
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        paint.setTextSize(50);
        //根据进度来画 就是当progress的进度不等于max也就是progress不等于100的时候 我们就画进度
        //当进度等于100的时候 我们就画文字
        if (progress != max) {
            canvas.drawText(progress + "%", 280, 300, paint);
        } else {
            canvas.drawText("完成了", 280, 300, paint);
        }


    }

}
