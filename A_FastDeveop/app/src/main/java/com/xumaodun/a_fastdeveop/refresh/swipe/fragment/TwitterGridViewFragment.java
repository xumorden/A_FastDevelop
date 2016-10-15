package com.xumaodun.a_fastdeveop.refresh.swipe.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.xumaodun.a_fastdeveop.R;
import com.xumaodun.a_fastdeveop.common.AppContext;
import com.xumaodun.a_fastdeveop.refresh.adapter.CharacterAdapter;
import com.xumaodun.a_fastdeveop.refresh.model.SectionCharacters;
import com.xumaodun.a_fastdeveop.refresh.swipe.Constants;
import com.xumaodun.a_fastdeveop.refresh.swipe.toolbox.GsonRequest;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwitterGridViewFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    private static final String TAG = TwitterGridViewFragment.class.getSimpleName();

    private SwipeToLoadLayout swipeToLoadLayout;

    private GridView gridView;

    private CharacterAdapter mAdapter;

    private int mPageNum;

    public TwitterGridViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new CharacterAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_twitter_grid_view, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeToLoadLayout = (SwipeToLoadLayout) view.findViewById(R.id.swipeToLoadLayout);
        gridView = (GridView) view.findViewById(R.id.swipe_target);

        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
        gridView.setAdapter(mAdapter);

        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    if (!ViewCompat.canScrollVertically(view, 1)) {
                        swipeToLoadLayout.setLoadingMore(true);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        swipeToLoadLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        AppContext.getRequestQueue().cancelAll(TAG + "refresh");
        AppContext.getRequestQueue().cancelAll(TAG+"loadmore");
        if (swipeToLoadLayout.isRefreshing()) {
            swipeToLoadLayout.setRefreshing(false);
        }
        if (swipeToLoadLayout.isLoadingMore()) {
            swipeToLoadLayout.setLoadingMore(false);
        }
    }

    @Override
    public void onRefresh() {
        GsonRequest request = new GsonRequest<SectionCharacters>(Constants.API.CHARACTERS, SectionCharacters.class, new Response.Listener<SectionCharacters>() {
            @Override
            public void onResponse(SectionCharacters characters) {
                mAdapter.setList(characters.getSections().get(0).getCharacters());
                swipeToLoadLayout.setRefreshing(false);
                mPageNum = 0;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                swipeToLoadLayout.setRefreshing(false);
                volleyError.printStackTrace();
            }
        });
        AppContext.getRequestQueue().add(request).setTag(TAG+"refresh");
    }

    @Override
    public void onLoadMore() {
        GsonRequest request = new GsonRequest<SectionCharacters>(Constants.API.CHARACTERS, SectionCharacters.class, new Response.Listener<SectionCharacters>() {
            @Override
            public void onResponse(SectionCharacters characters) {
                if (mPageNum < 3) {
                    mPageNum++;
                    mAdapter.append(characters.getSections().get(mPageNum).getCharacters());
                }else{
                    Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                }
                swipeToLoadLayout.setLoadingMore(false);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                swipeToLoadLayout.setLoadingMore(false);
                volleyError.printStackTrace();
            }
        });
        AppContext.getRequestQueue().add(request).setTag(TAG+"loadmore");

    }


}
