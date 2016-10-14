package com.xumaodun.a_fastdeveop.refresh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xumaodun.a_fastdeveop.R;
import com.xumaodun.a_fastdeveop.refresh.commonrefresh.CommonRefreshActivity;

public class RefreshActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        initActionBar();
    }

    public void initActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setTitle("下拉刷新");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.btn_back_press);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void MaterialRefresh(View view){
        intent = new Intent(this, MaterialActivity.class);
        startActivity(intent);
    }

    public void pullToRefresh(View view){
        intent = new Intent(this, CommonRefreshActivity.class);
        startActivity(intent);
    }

}
