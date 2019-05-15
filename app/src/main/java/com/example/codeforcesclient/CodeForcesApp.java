package com.example.codeforcesclient;

import android.app.Activity;
import android.app.Application;

import com.example.codeforcesclient.di.AppInjector;
import com.example.codeforcesclient.di.components.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class CodeForcesApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        AppInjector.init(this);
    }



    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return mDispatchingAndroidInjector;
    }
}