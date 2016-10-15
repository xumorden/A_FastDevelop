package com.xumaodun.a_fastdeveop.refresh.swipe;

import android.support.v4.app.Fragment;

import com.aspsine.fragmentnavigator.FragmentNavigatorAdapter;
import com.xumaodun.a_fastdeveop.refresh.swipe.fragment.NavGoogleFragment;
import com.xumaodun.a_fastdeveop.refresh.swipe.fragment.NavJDFragment;
import com.xumaodun.a_fastdeveop.refresh.swipe.fragment.NavJavaCodeFragment;
import com.xumaodun.a_fastdeveop.refresh.swipe.fragment.NavTwitterFragment;
import com.xumaodun.a_fastdeveop.refresh.swipe.fragment.NavYalantisFragment;

/**
 * Created by aspsine on 16/4/28.
 */
public class MainFragmentAdapter implements FragmentNavigatorAdapter {

    @Override
    public Fragment onCreateFragment(int position) {
        switch (position) {
            case 0:
                return NavTwitterFragment.newInstance();

            case 1:
                return NavGoogleFragment.newInstance();

            case 2:
                return NavYalantisFragment.newInstance();

            case 3:
                return NavJDFragment.newInstance();

            case 4:
                return NavJavaCodeFragment.newInstance();
        }
        return null;
    }

    @Override
    public String getTag(int position) {
        return String.valueOf(position);
    }

    @Override
    public int getCount() {
        return 5;
    }
}