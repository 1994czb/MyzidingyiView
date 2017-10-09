package com.example.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.view.view.MyCircleView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
        //bitmap工厂类
        Bitmap bitmapFactory = BitmapFactory.decodeResource(getResources(),R.drawable.aaa);
        imageView.setImageDrawable(new MyCircleView(bitmapFactory));

    }
}
