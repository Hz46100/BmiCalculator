package com.example.jinjin.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setting extends AppCompatActivity {
Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //把activity背景变成黑色
                getWindow().getDecorView().setBackgroundResource(R.color.black);
                //再次点击按钮恢复原来的颜色
                btn_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getWindow().getDecorView().setBackgroundResource(R.color.white);
                    }
                });
            }
        });
    }
    //删除系统默认的标题栏
    //onWindowFocusChanged方法是在Activity的onCreate方法执行完毕后才执行的，所以在这里我们可以使用，
    // 因为在onCreate方法中我们已经设置了一个标题栏，所以在这里我们可以删除系统默认的标题栏。
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
           NoBar();
        }
    }

    private void NoBar() {
        //隐藏导航栏
        if (getSupportActionBar() != null) {
            //显示标题为设置
            getSupportActionBar().setTitle("设置");
            //getSupportActionBar().hide();//hide是隐藏，show是显示
        }
        //隐藏状态栏
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

}