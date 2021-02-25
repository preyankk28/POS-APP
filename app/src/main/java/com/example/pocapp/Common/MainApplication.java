package com.example.pocapp.Common;

import android.app.Application;

import com.example.pocapp.Common.ApiManager;

public class MainApplication extends Application {

    public static ApiManager apiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        apiManager = ApiManager.getInstance();
    }
}