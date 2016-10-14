package com.xumaodun.a_fastdeveop.refresh.pull;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
    private ArrayList<String> arrayList;
    private MyAdapter adapter;

    //和下拉刷新有关的逻辑
    private int total;           //总数
    private int pageNumber = 1;        //页数
    private boolean isupdate=false;  //是否下拉刷新

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gridview);
//        initData();
        initView();
    }
    private void initView() {
        mgridView = (GridViewWithHeaderAndFooter) findViewById(R.id.load_more_grid_view);
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
                initData();
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
                getMoreDataFromServer();
            }
        });
        initData();
    }

    private void getMoreDataFromServer(){
        pageNumber++;
        //"&page="+pageNumber+"+&size=10"
        ArrayList<String> moreData = new ArrayList<String>();
        moreData.add("six");
        moreData.add("seven");
        moreData.add("eight");
        moreData.add("nine");
        moreData.add("ten");
        moreData.add("elven");

        if(isupdate){
            pageNumber=1;
            //完成下拉刷新
            frameLayout.refreshComplete();
            arrayList.clear();
        }
        //
        loadMoreContainer.loadMoreFinish(isEmpty(arrayList), hasMore());
        if(moreData != null){
            arrayList.addAll(moreData);
        }
        adapter.notifyDataSetChanged();

    }


    private void initData() {
        getDataFromServicer();
    }

    private void getDataFromServicer() {
        //path+"&page=1&size=10"
        total = 50;
        arrayList = new ArrayList<String>();
        arrayList.add("zeno");
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.add("four");
        arrayList.add("five");

        adapter = new MyAdapter(this, arrayList);
        mgridView.setAdapter(adapter);
    }

    private boolean hasMore() {
        //每一页显示数据
        return pageNumber <= AlgorithmUtils.getPagerSize(total, 10);
    }

    private boolean isEmpty(ArrayList<String> data) {
        return data == null || data.size() == 0;
    }

    class MyAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<String> arrayList;

        public MyAdapter(Context context, ArrayList<String> arrayList){
            this.context = context;
            this.arrayList = arrayList;
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public String getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder mHolder;
            if(convertView == null){
                mHolder = new ViewHolder();
                convertView = View.inflate(context, R.layout.gride_item, null);
                mHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
                convertView.setTag(mHolder);
            }else{
                mHolder = (ViewHolder) convertView.getTag();
            }
            String item = getItem(position);
            mHolder.tvTitle.setText(item);
            return convertView;
        }
    }

    static class ViewHolder{
        public TextView tvTitle;
    }

}
