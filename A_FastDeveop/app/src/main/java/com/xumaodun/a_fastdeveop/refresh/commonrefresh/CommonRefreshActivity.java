package com.xumaodun.a_fastdeveop.refresh.commonrefresh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xumaodun.a_fastdeveop.R;

public class CommonRefreshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_refresh);
    }

    public void goListView(View view) {
        startActivity(new Intent(this, ListViewActivity.class));
    }

    public void goRecyclerView(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void goGridView(View view) {
        startActivity(new Intent(this, GridViewAtivity.class));
    }

    public void goSwipeListView(View view) {
        startActivity(new Intent(this, SwipeListViewActivity.class));
    }

}
