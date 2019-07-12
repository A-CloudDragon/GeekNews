package com.jiyun.geeknews.app;

import android.app.Application;

public class GeekApplication extends Application {
    private static GeekApplication app;

    public static GeekApplication getApp() {
        return app;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
    }
}
