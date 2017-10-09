package com.example.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.view.view.MyCircleView;
import com.example.view.view.MySquareView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
        imageView2 = (ImageView) findViewById(R.id.image2);
        //bitmap工厂类
        Bitmap bitmapFactory = BitmapFactory.decodeResource(getResources(),R.drawable.aaa);
        imageView.setImageDrawable(new MyCircleView(bitmapFactory));
        imageView2.setImageDrawable(new MySquareView(bitmapFactory));

    }
}
