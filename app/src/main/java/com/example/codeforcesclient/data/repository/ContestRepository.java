package com.example.codeforcesclient.data.repository;

import android.util.Log;

import com.example.codeforcesclient.data.local.dao.ContestDao;
import com.example.codeforcesclient.data.local.model.Contest;
import com.example.codeforcesclient.data.remote.CodeForcesResponse;
import com.example.codeforcesclient.data.remote.ContestService;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class ContestRepository {

    private static final String TAG = "ContestRepository";
    private ContestService mContestService;

    private static final int FRESH_TIMOUT_IN_S = 2 * 60;

    private ContestDao mContestDao;

//    @Inject
//    public ContestRepository(ContestDao aContestDao) {
//        mContestDao = aContestDao;
//    }

    @Inject
    public ContestRepository(ContestService aContestService) {
        mContestService = aContestService;
    }

    public LiveData<List<Contest>> getContests() {
        final MutableLiveData<List<Contest>> contests = new MutableLiveData<>();
//        CodeForcesResponse<List<Contest>> contests;

        Call<CodeForcesResponse<List<Contest>>> contestsCall = mContestService.getContests(false);

        contestsCall.enqueue(new Callback<CodeForcesResponse<List<Contest>>>() {
            @Override
            public void onResponse(@NonNull Call<CodeForcesResponse<List<Contest>>> call, @NonNull Response<CodeForcesResponse<List<Contest>>> response) {
                Log.w(TAG, response.toString());
                contests.setValue(response.body().getResult());
            }

            @Override
            public void onFailure(@NonNull Call<CodeForcesResponse<List<Contest>>> call, @NonNull Throwable t) {
                contests.setValue(Collections.emptyList());
                Log.w(TAG, "Failed to load contests from server");
            }
        });
        return contests;
//        try {
//            contests.postValue(contestsCall.execute().body());
//        } catch (IOException aE) {
//            aE.printStackTrace();
//        }
//
//        return null;
    }


}
