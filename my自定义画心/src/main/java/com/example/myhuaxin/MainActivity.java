package com.example.myhuaxin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView) findViewById(R.id.myview);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);
        myView.setBitmap(bitmap);
    }
}
