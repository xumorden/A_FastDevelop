package com.xumaodun.a_fastdeveop.refresh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xumaodun.a_fastdeveop.R;

public class MaterialActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        initActionBar();
    }

    public void initActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setTitle("Material下拉刷新");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.btn_back_press);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void ScrollView(View view){
        //getBaseContext()
        intent = new Intent(this, ScrollViewActivity.class);
        startActivity(intent);
    }

    public void RecyclerView(View view){
        intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }

    public void WaveView(View view){
        intent = new Intent(this, WaveViewActivity.class);
        startActivity(intent);
    }

    public void LoadMoreView(View view){
        intent = new Intent(this, LoadMoreViewActivity.class);
        startActivity(intent);
    }
}
