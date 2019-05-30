package com.example.codeforcesclient.data.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.codeforcesclient.data.local.dao.ProblemDao;
import com.example.codeforcesclient.data.local.model.Problem;
import com.example.codeforcesclient.data.remote.CodeForcesResponse;
import com.example.codeforcesclient.data.remote.ProblemsResponce;
import com.example.codeforcesclient.data.remote.service.ProblemService;
import com.example.codeforcesclient.utils.LoadExecutors;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProblemRepository extends BaseRepository {

    private static final String TAG = "ProblemRepository";

    private ProblemService mProblemService;
    private ProblemDao mProblemDao;
    private List<Problem> mCashedProblems;

    @Inject
    public ProblemRepository(ProblemService aProblemService, ProblemDao aProblemDao, LoadExecutors aLoadExecutors) {
        super(aLoadExecutors);
        mProblemService = aProblemService;
        mProblemDao = aProblemDao;
    }

    public LiveData<List<Problem>> getProblems() {
        if (!isCashed()) {
            fetchProblems();
            setCashed(true);
        }

        return mProblemDao.loadAll();
    }

    public LiveData<List<Problem>> getProblemsForContest(int aContestId) {
        MutableLiveData<List<Problem>> problems = new MutableLiveData<>();
        if (problems.getValue() == null) {
            fetchProblemsForContest(() -> {
                mCashedProblems = mCashedProblems.stream().filter(aProblem -> aProblem.getContestId() == aContestId).collect(Collectors.toList());
                problems.setValue(mCashedProblems);
            });
        }

        return problems;l
    }

    interface ProblemsLoadCallback {
        void loaded();
    }

    private void fetchProblemsForContest(ProblemsLoadCallback aCallback) {
        Call<CodeForcesResponse<ProblemsResponce>> problemsCall = mProblemService.getProblems();
        problemsCall.enqueue(new Callback<CodeForcesResponse<ProblemsResponce>>() {
            @Override
            public void onResponse(@NonNull Call<CodeForcesResponse<ProblemsResponce>> call,
                                   @NonNull Response<CodeForcesResponse<ProblemsResponce>> response) {
                if (response.body() != null) {
                    addStatisticsToProblems(response.body().getResult());
                    executeLocal(() -> mProblemDao.updateData(response.body().getResult().getProblems()));
                }
                mCashedProblems = response.body().getResult().getProblems();
                aCallback.loaded();
            }

            @Override
            public void onFailure(@NonNull Call<CodeForcesResponse<ProblemsResponce>> call, @NonNull Throwable t) {
                Log.w(TAG, "Failed to load Problems from server. " + t);
            }
        });
    }

    private void fetchProblems() {
        Call<CodeForcesResponse<ProblemsResponce>> problemsCall = mProblemService.getProblems();
        problemsCall.enqueue(new Callback<CodeForcesResponse<ProblemsResponce>>() {
            @Override
            public void onResponse(@NonNull Call<CodeForcesResponse<ProblemsResponce>> call,
                                   @NonNull Response<CodeForcesResponse<ProblemsResponce>> response) {
                if (response.body() != null) {
                    addStatisticsToProblems(response.body().getResult());
                    executeLocal(() -> mProblemDao.updateData(response.body().getResult().getProblems()));
                }
                mCashedProblems = response.body().getResult().getProblems();
            }

            @Override
            public void onFailure(@NonNull Call<CodeForcesResponse<ProblemsResponce>> call, @NonNull Throwable t) {
                Log.w(TAG, "Failed to load Problems from server. " + t);
            }
        });
    }

    private void addStatisticsToProblems(ProblemsResponce aProblemsResponce) {
        for (int i = 0; i < aProblemsResponce.getProblems().size(); i++) {
            int solved = aProblemsResponce.getProblemStatistics().get(i).getSolvedCount();
            aProblemsResponce.getProblems().get(i).setSolvedCount(solved);
        }
    }

}
