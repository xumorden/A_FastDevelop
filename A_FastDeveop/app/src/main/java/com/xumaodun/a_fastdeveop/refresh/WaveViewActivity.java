package com.xumaodun.a_fastdeveop.refresh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.xumaodun.a_fastdeveop.R;

import java.util.ArrayList;
import java.util.List;

public class WaveViewActivity extends AppCompatActivity {

    private MaterialRefreshLayout materialRefreshLayout;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_view);

        materialRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.refresh);

        materialRefreshLayout.setWaveShow(true);
        materialRefreshLayout.setWaveColor(Color.parseColor("#60ff2020"));

        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialRefreshLayout.finishRefresh();

                    }
                }, 3000);
                materialRefreshLayout.finishRefreshLoadMore();

            }

            @Override
            public void onfinish() {
                Toast.makeText(WaveViewActivity.this, "finish", Toast.LENGTH_LONG).show();
            }

        });

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerview);
        setupRecyclerView(rv);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(this, mDatas));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'G'; i++) {
            mDatas.add("" + (char) i);
        }
    }
}
