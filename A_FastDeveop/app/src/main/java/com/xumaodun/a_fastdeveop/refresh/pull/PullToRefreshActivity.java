package com.xumaodun.a_fastdeveop.refresh.pull;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xumaodun.a_fastdeveop.R;

public class PullToRefreshActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_refresh);
    }

    public void GridViewActivity(View view){
        intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
    }
}
