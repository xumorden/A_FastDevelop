package com.xumaodun.a_fastdeveop.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xumaodun.a_fastdeveop.R;

public class SplashActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initActionBar();
    }

    public void initActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setTitle("引导层");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.btn_back_press);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //传统的activity
    public void splashone(View view){
        intent = new Intent(this, SplashOneActivity.class);
        startActivity(intent);
    }
    //流行的activity
    public void splashtwo(View view){
        intent = new Intent(this, SplashTwoActivity.class);
        startActivity(intent);
    }


}
