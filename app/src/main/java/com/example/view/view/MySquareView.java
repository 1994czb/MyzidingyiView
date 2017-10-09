package com.example.view.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/10/9.
 */

public class MySquareView extends Drawable {
    private Paint paint;
    private Bitmap bitmap;
    private final int width;
    private final int height;

    public MySquareView(Bitmap bitmap) {
        this.bitmap = bitmap;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);//设置抗锯齿
        //着色器
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //原理就是我们把着色器给着色到paint上面
        //然后我们再绘制的时候就相当于paint上已经有图片了
        paint.setShader(shader);
        //拿到实际的宽和高
        width = bitmap.getWidth();
        height = bitmap.getHeight();
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawRect(300, 80, 400, 160, paint);

    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {

        paint.setAlpha(i);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
    //实际的宽
    @Override
    public int getIntrinsicWidth() {
        return width;
    }

    //实际的高
    @Override
    public int getIntrinsicHeight() {
        return height;
    }

}
