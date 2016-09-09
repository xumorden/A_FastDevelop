package com.xumaodun.a_fastdeveop.viewpager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xumaodun.a_fastdeveop.R;
import com.zhy.magicviewpager.transformer.ScaleInTransformer;

import butterknife.Bind;
import butterknife.ButterKnife;

//https://github.com/hongyangAndroid/MagicViewPager
//横向viewpager
//效果在手机上显示正确
public class ViewPagerAvtivity extends FragmentActivity {

    @Bind(R.id.id_viewpager)
    ViewPager mViewPager;

    int[] imgRes = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,R.drawable.e,R.drawable.f};
    private PagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_avtivity);
        ButterKnife.bind(this);
        //设置Page间间距
        mViewPager.setPageMargin(5);
        //设置缓存的页面数量
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView view = new ImageView(getBaseContext());
                view.setImageResource(imgRes[position]);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public int getCount()
            {
                return imgRes.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object o)
            {
                return view == o;
            }
        });
        //setPageTransformer 决定动画效果
        mViewPager.setPageTransformer(true, new ScaleInTransformer());
    }
}
