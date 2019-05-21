package com.example.codeforcesclient.data.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.codeforcesclient.data.local.dao.ContestDao;
import com.example.codeforcesclient.data.local.model.Contest;
import com.example.codeforcesclient.data.remote.CodeForcesResponse;
import com.example.codeforcesclient.data.remote.service.ContestService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class ContestRepository {

    private static final String TAG = "ContestRepository";
    private ContestService mContestService;
    private static final int FRESH_TIMOUT_IN_S = 2 * 60;
    private ContestDao mContestDao;

    @Inject
    public ContestRepository(ContestDao aContestDao, ContestService aContestService) {
        mContestDao = aContestDao;
        mContestService = aContestService;
    }

    public LiveData<List<Contest>> getContests() {
        fetchContests();

        return mContestDao.loadAll();
    }

    private void fetchContests() {
        Call<CodeForcesResponse<List<Contest>>> contestsCall = mContestService.getContests(false);
        contestsCall.enqueue(new Callback<CodeForcesResponse<List<Contest>>>() {
            @Override
            public void onResponse(@NonNull Call<CodeForcesResponse<List<Contest>>> call,
                                   @NonNull Response<CodeForcesResponse<List<Contest>>> response) {
                if (response.body() != null) {
                    new Thread(() -> {
                        mContestDao.deleteAll();
                        mContestDao.insertAll(response.body().getResult());
                    }).start();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CodeForcesResponse<List<Contest>>> call, @NonNull Throwable t) {
                Log.w(TAG, "Failed to load contests from server. " + t);
            }
        });
    }
}
