package com.example.codeforcesclient.data.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.codeforcesclient.data.local.dao.ContestDao;
import com.example.codeforcesclient.data.local.model.Contest;
import com.example.codeforcesclient.data.remote.CodeForcesResponse;
import com.example.codeforcesclient.data.remote.service.ContestService;
import com.example.codeforcesclient.utils.LoadExecutors;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class ContestRepository extends BaseRepository{

    private static final String TAG = "ContestRepository";
    private ContestService mContestService;
    private ContestDao mContestDao;

    @Inject
    ContestRepository(ContestDao aContestDao, ContestService aContestService, LoadExecutors aLoadExecutors) {
        super(aLoadExecutors);
        mContestDao = aContestDao;
        mContestService = aContestService;
    }

    public LiveData<List<Contest>> getContests() {
        if (!isCashed()) {
            fetchContests();
            setCashed(true);
        }

        return mContestDao.loadAll();
    }

    private void fetchContests() {
        Call<CodeForcesResponse<List<Contest>>> contestsCall = mContestService.getContests(false);
        contestsCall.enqueue(new Callback<CodeForcesResponse<List<Contest>>>() {
            @Override
            public void onResponse(@NonNull Call<CodeForcesResponse<List<Contest>>> call,
                                   @NonNull Response<CodeForcesResponse<List<Contest>>> response) {
                if (response.body() != null) {
                    executeLocal(() -> mContestDao.updateData(response.body().getResult()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<CodeForcesResponse<List<Contest>>> call, @NonNull Throwable t) {
                Log.w(TAG, "Failed to load contests from server. " + t);
            }
        });
    }
}
