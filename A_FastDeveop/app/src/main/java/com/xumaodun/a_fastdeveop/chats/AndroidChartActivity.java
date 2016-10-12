package com.xumaodun.a_fastdeveop.chats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xumaodun.a_fastdeveop.R;

public class AndroidChartActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_chart);
    }

    public void LineFragmentActivity(View view){
        intent = new Intent(this, LineFragmentActivity.class);
        startActivity(intent);
    }

    public void PieFragmentActivity(View view){
        intent = new Intent(this, PieFragmentActivity.class);
        startActivity(intent);
    }

    public void BarFragmentActivity(View view){
        intent = new Intent(this, BarFragmentActivity.class);
        startActivity(intent);
    }

    public void ClockPieFragmentActivity(View view){
        intent = new Intent(this, ClockPieFragmentActivity.class);
        startActivity(intent);
    }


}
