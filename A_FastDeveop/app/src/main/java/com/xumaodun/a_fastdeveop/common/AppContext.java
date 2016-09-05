package com.xumaodun.a_fastdeveop.common;

import android.app.Application;

public class AppContext extends Application {

    private static AppContext app;

    public AppContext() {
        app = this;
    }

    public static synchronized AppContext getInstance() {
        if (app == null) {
            app = new AppContext();
        }
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //使用leakcanary监测内存泄露
        //https://github.com/square/leakcanary
        //LeakCanary.install(this);
        //registerUncaughtExceptionHandler();
    }

    // 注册App异常崩溃处理器
    private void registerUncaughtExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(AppException.getAppExceptionHandler());
    }

}