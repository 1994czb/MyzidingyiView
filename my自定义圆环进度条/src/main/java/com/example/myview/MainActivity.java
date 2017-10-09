package com.example.myview;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.example.myview.view.MyView;

public class MainActivity extends AppCompatActivity {

    private int i=0;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //根据不通值来设定不同的颜色
            if(i<=25){
                myView.setColor(Color.GREEN);
                myView.setProgress(i);
            }else if(i<=50){
                myView.setColor(Color.parseColor("#FF0080"));
                myView.setProgress(i);
            }else if(i<=75){
                myView.setColor(Color.BLUE);
                myView.setProgress(i);
            }else if(i<=100){
                myView.setColor(Color.YELLOW);
                myView.setProgress(i);
            }else{
                i=100;
            }
            handler.sendEmptyMessageDelayed(i++,300);
        }
    };
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView)findViewById(R.id.myview);
        myView.setMax(100);
        //通过handler来无线发送消息 正长情况下为了减少内存泄漏需要在生命周期结束的时候把消息清空
        handler.sendEmptyMessage(i++);




    }
}
