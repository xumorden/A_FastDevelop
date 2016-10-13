package com.xumaodun.a_fastdeveop.fadingindicator;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xumaodun.a_fastdeveop.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Fragment to use customized indicators.
 * Created by ugurtekbas.
 */
public class CustomizedFragment extends Fragment {

    private CustomizedAdapter adapter;
    @Bind(R.id.viewpagerCustomized)
    ViewPager viewpagerCustomized;
    @Bind(R.id.circleIndicator) FadingIndicator indicator;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView =  inflater.inflate(R.layout.fragment_customized, null);
        ButterKnife.bind(this, fragmentView);

        int[] pics = {
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
        };

        adapter = new CustomizedAdapter(getContext(),pics);
        viewpagerCustomized.setAdapter(adapter);
        viewpagerCustomized.setCurrentItem(2);
        indicator.setViewPager(viewpagerCustomized);

        return fragmentView;
    }
}