package com.example.jinjin.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText weight, height;
    Button btn, nan, nv;
    TextView shuchu;
    String info = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //寻找组件
        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);
        btn = (Button) findViewById(R.id.btn);
        nan = (RadioButton) findViewById(R.id.nan);
        nv = (RadioButton) findViewById(R.id.nv);
        shuchu = (TextView) findViewById(R.id.shuchu);
        //给RadioGroup1绑定监听器
        nan.setOnClickListener(this);
        nv.setOnClickListener(this);
        //Button绑定监听器
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shuchu.setText(info);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, height.getText().toString() + "cm", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, weight.getText().toString() + "kg", Toast.LENGTH_SHORT).show();
        double h = Double.parseDouble(height.getText().toString());
        double w = Double.parseDouble(weight.getText().toString());
        double bmi;
        switch (v.getId()) {
            //男
            case R.id.nan:
                if (h <= 0 || w <= 0) {
                    info = "值异常，请重新输入";
                    return;
                }
                h = h / 100;
                bmi = w / (h * h);
                if (bmi < 18.4) {
                    info = "你的体型：偏瘦" + "\t" + "boy太瘦女孩子们可不喜欢！";
                } else if (bmi > 24.9) {
                    info = "你的体型：偏胖" + "\t" + "可以减脂锻炼啦！";
                } else if (bmi > 18.5 && bmi < 24.9) {
                    info = "你的体型：正常" + "\t" + "不错不错再接再厉!";
                }
                break;
            //女
            case R.id.nv:
                h = h / 100;
                bmi = w / (h * h);
                if (bmi < 18.4) {
                    info = "你的体型：偏瘦" + "\t" + "小仙女别再减肥啦！";
                } else if (bmi > 24.9) {
                    info = "你的体型：偏胖" + "\t" + "仙女记得运动一下哦!";
                } else if (bmi > 18.5 && bmi < 24.9) {
                    info = "你的体型：正常" + "\t" + "果然是小仙女呢!";
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "软件介绍");
        menu.add(1, 2, 2, "退出软件");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(this, "你点击了软件介绍", Toast.LENGTH_SHORT).show();
                //跳转到软件介绍页面
                Intent intent1 = new Intent(MainActivity.this, introduce.class);
                startActivity(intent1);
                return true;
            case 2:
                //关闭软件
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}