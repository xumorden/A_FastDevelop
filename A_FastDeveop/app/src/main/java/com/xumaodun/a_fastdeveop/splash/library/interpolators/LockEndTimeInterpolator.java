package com.xumaodun.a_fastdeveop.splash.library.interpolators;

import android.animation.TimeInterpolator;

/**
 * Created by linfaxin on 2015/8/9.
 * Email: linlinfaxin@163.com
 */
public class LockEndTimeInterpolator extends WrappedTimeInterpolator{
    public LockEndTimeInterpolator(TimeInterpolator wrapped) {
        super(wrapped);
    }
    @Override
    public float getInterpolation(float input) {
        return 1;
    }
}
