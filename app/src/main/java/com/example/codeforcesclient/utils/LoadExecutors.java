package com.example.codeforcesclient.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

@Singleton
public class LoadExecutors {

    private final Executor mLocalExecutor;

    private final Executor mNetworkExecutor;

    public LoadExecutors(Executor aLocalExecutor, Executor aNetworkExecutor) {
        mLocalExecutor = aLocalExecutor;
        mNetworkExecutor = aNetworkExecutor;
    }

    public static LoadExecutors createDefaultLoadExecutors() {
        return new LoadExecutors(Executors.newSingleThreadExecutor(), Executors.newSingleThreadExecutor());
    }

    public Executor getLocalExecutor() {
        return mLocalExecutor;
    }

    public Executor getNetworkExecutor() {
        return mNetworkExecutor;
    }
}
