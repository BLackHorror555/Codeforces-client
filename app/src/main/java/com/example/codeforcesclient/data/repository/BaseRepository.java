package com.example.codeforcesclient.data.repository;

import androidx.annotation.NonNull;

import com.example.codeforcesclient.utils.LoadExecutors;

public class BaseRepository {

    private LoadExecutors mLoadExecutors;
    private boolean mIsCashed = false;

    BaseRepository(LoadExecutors aLoadExecutors) {
        mLoadExecutors = aLoadExecutors;
    }

    public void setLoadExecutors(LoadExecutors aLoadExecutors) {
        mLoadExecutors = aLoadExecutors;
    }

    void executeLocal(@NonNull Runnable aRunnable) {
        mLoadExecutors.getLocalExecutor().execute(aRunnable);
    }

    public void executeNetwork(@NonNull Runnable aRunnable) {
        mLoadExecutors.getNetworkExecutor().execute(aRunnable);
    }

    boolean isCashed() {
        return mIsCashed;
    }

    void setCashed(boolean aCashed) {
        mIsCashed = aCashed;
    }
}
