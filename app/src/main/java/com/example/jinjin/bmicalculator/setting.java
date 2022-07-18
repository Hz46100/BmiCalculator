package com.example.jinjin.bmicalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class setting extends AppCompatActivity {
    Button btn_back;
    int count = 0;
    private static final String TAG = "setting";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        btn_back = findViewById(R.id.btn_back);
        //去除系统标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        //自定义标题栏
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("设置");
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                //点击按钮判断count是否为单数，如果是，则变黑色，否则恢复白色
                if (count % 2 == 1) {
                    //把activity背景变成黑色
                    getWindow().getDecorView().setBackgroundResource(R.drawable.background);
                    //改变按钮的文本
                    btn_back.setText("护眼模式");
                } else if (count % 2 == 0) {
                    //再次点击按钮恢复原来的颜色
                    getWindow().getDecorView().setBackgroundResource(R.color.white);
                    //改变按钮的文本
                    btn_back.setText("恢复");
                }
            }
        });
    }
}