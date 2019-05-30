package com.example.codeforcesclient.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.codeforcesclient.data.local.model.Problem;
import com.example.codeforcesclient.data.repository.ProblemRepository;

import java.util.List;

import javax.inject.Inject;

public class ProblemListViewModel extends ViewModel {

    private LiveData<List<Problem>> problems;
    private LiveData<List<Problem>> mProblemsForContest;
    private ProblemRepository mProblemRepository;

    @Inject
    public ProblemListViewModel(ProblemRepository aProblemRepository) {
        problems = aProblemRepository.getProblems();
        mProblemRepository = aProblemRepository;
    }

    public LiveData<List<Problem>> getProblemsForContest(int aContestId) {
        return mProblemsForContest = mProblemRepository.getProblemsForContest(aContestId);
    }

    public LiveData<List<Problem>> getProblems() {
        return problems;
    }
}
