package com.example.jinjin.bmicalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class introduce extends AppCompatActivity {
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        tv1 = (TextView) findViewById(R.id.tv1);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("软件介绍");
        tv1.setText(Html.fromHtml("<a href='http://beian.miit.gov.cn/'>闽ICP备2022001998号</a><br/><a href='http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=35072502001025'>闽公网安备35072502001025号</a>"));
        tv1.setMovementMethod(LinkMovementMethod.getInstance());
    }


}