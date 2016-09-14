package com.xumaodun.a_fastdeveop.refresh.pull;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xumaodun.a_fastdeveop.R;
import com.xumaodun.a_fastdeveop.utils.AlgorithmUtils;

import java.util.ArrayList;

import in.srain.cube.views.GridViewWithHeaderAndFooter;
import in.srain.cube.views.loadmore.LoadMoreContainer;
import in.srain.cube.views.loadmore.LoadMoreGridViewContainer;
import in.srain.cube.views.loadmore.LoadMoreHandler;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class GridViewActivity extends AppCompatActivity {

    private PtrClassicFrameLayout frameLayout;
    private LoadMoreGridViewContainer loadMoreContainer;
    private GridViewWithHeaderAndFooter mgridView;

    //和下拉刷新有关的逻辑
    private int total;           //总数
    private int pageNumber = 1;        //页数
    private boolean isupdate=false;  //是否下拉刷新

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        initData();
        initView();
    }
    private void initView() {
        mgridView = (GridViewWithHeaderAndFooter) findViewById(R.id.content_view);
        frameLayout=(PtrClassicFrameLayout)findViewById(R.id.toppicdetail_ptr_frame);
        loadMoreContainer=(LoadMoreGridViewContainer)findViewById(R.id.load_more_grid_view_container);
        frameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mgridView, header);
            }
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //下拉刷新    刷新开始的时候
                isupdate=true;
//                initData();
                frameLayout.refreshComplete();
            }
        });
        //设置手动刷新
        frameLayout.autoRefresh(false);
        //上拉加载更多
        //使用默认的头部
        loadMoreContainer.useDefaultHeader();
        //设置为自动刷新
        loadMoreContainer.setAutoLoadMore(true);
        //加载更多
        loadMoreContainer.setLoadMoreHandler(new LoadMoreHandler() {
            @Override
            public void onLoadMore(LoadMoreContainer loadMoreContainer) {
                //加载更多的时候请求数据
                isupdate=false;
//                getMoreDataFromServer(path);
            }
        });
    }

    private void initData() {
        getDataFromServicer();
    }

    private void getDataFromServicer() {
        //path+"&page=1&size=10"
    }

    private boolean hasMore() {
        //每一页显示数据
        return pageNumber <= AlgorithmUtils.getPagerSize(total, 10);
    }

    private boolean isEmpty(ArrayList<String> data) {
        return data == null || data.size() == 0;
    }

}
