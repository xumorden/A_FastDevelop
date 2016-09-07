package com.xumaodun.a_fastdeveop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xumaodun.a_fastdeveop.splash.SplashActivity;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActionBar();
    }

    public void initActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setTitle("主页面");
        setSupportActionBar(toolbar);
    }

    public void mainActivity(View view) {
        intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
    }
}
