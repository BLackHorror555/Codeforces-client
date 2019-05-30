package com.example.codeforcesclient.ui;

import androidx.lifecycle.ViewModelProviders;

import com.example.codeforcesclient.viewmodel.ProblemListViewModel;

public class ProblemForContestFragment extends ProblemFragment {
    private int mContestId;

    public ProblemForContestFragment(int aContestId) {
        mContestId = aContestId;
    }

    @Override
    void observeViewModel() {
        ProblemListViewModel mProblemListViewModel = ViewModelProviders.of(this, mFactory).get(ProblemListViewModel.class);
        mProblemListViewModel.getProblemsForContest(mContestId).observe(this, this::updateProblems);
    }
}
