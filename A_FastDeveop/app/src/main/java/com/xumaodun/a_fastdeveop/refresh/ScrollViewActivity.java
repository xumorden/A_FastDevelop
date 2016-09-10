package com.xumaodun.a_fastdeveop.refresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.xumaodun.a_fastdeveop.R;

public class ScrollViewActivity extends AppCompatActivity {

    private MaterialRefreshLayout materialRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        materialRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.refresh);
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // TODO 更新数据  initData();
                        materialRefreshLayout.finishRefresh();
                    }
                }, 3000);
                materialRefreshLayout.finishRefreshLoadMore();
                //TODO arrayList.addAll(moreData); adapter.notifyDataSetChanged();
            }

            @Override
            public void onfinish() {
                Toast.makeText(ScrollViewActivity.this, "finish", Toast.LENGTH_LONG).show();
            }
        });
    }
}
