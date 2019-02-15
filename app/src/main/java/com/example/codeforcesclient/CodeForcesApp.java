package com.example.codeforcesclient;

import android.app.Application;

import com.example.codeforcesclient.di.components.AppComponent;
import com.example.codeforcesclient.di.components.DaggerAppComponent;
import com.example.codeforcesclient.di.modules.AppModule;
import com.example.codeforcesclient.di.modules.NetModule;

public class CodeForcesApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
//                .appModule(new AppModule(this))
//                .netModule(new NetModule("http://codeforces.com/api/"))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
