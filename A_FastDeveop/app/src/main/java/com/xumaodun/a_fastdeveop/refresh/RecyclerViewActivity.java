package com.xumaodun.a_fastdeveop.refresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.xumaodun.a_fastdeveop.R;

import java.util.ArrayList;
import java.util.List;

//长按删除,短点击相应,下拉刷新
public class RecyclerViewActivity extends AppCompatActivity {

    private MaterialRefreshLayout materialRefreshLayout;
    private List<String> mDatas;
    private SimpleStringRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        materialRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.refresh);
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialRefreshLayout.finishRefresh();
                        mAdapter.addData(0);
                    }
                }, 3000);
                materialRefreshLayout.finishRefreshLoadMore();
            }

            @Override
            public void onfinish() {
                Toast.makeText(RecyclerViewActivity.this, "finish", Toast.LENGTH_LONG).show();
//                mAdapter.addData(1);
            }

        });

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerview);
        setupRecyclerView(rv);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        initData();
        mAdapter= new SimpleStringRecyclerViewAdapter(RecyclerViewActivity.this, mDatas);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        initEvent();
    }

    private void initEvent() {
        mAdapter.setOnItemClickLitener(new SimpleStringRecyclerViewAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, position + " click",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, position + " long click",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'G'; i++) {
            mDatas.add("" + (char) i);
        }
    }
}
