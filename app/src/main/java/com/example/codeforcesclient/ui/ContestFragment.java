package com.example.codeforcesclient.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.codeforcesclient.R;
import com.example.codeforcesclient.data.local.model.Contest;
import com.example.codeforcesclient.di.Injectable;
import com.example.codeforcesclient.ui.adapters.ContestClickListener;
import com.example.codeforcesclient.ui.adapters.ContestsAdapter;
import com.example.codeforcesclient.viewmodel.ContestViewModel;

import java.util.Collections;
import java.util.List;

public class ContestFragment extends BaseRecycleViewFragment<ContestsAdapter> implements Injectable {

    protected ContestClickListener mContestClickListener = aContest -> {
        if (aContest.getPhase().equals(Contest.ContestPhase.FINISHED)) {
            ProblemFragment problemFragment = new ProblemForContestFragment(aContest.getId());
            ((MainActivity) getActivity()).showFragmentWithBackStack(problemFragment);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contest, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recycle_view_contests);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected ContestsAdapter createAdapter() {
        return new ContestsAdapter(Collections.emptyList(), mContestClickListener);
    }

    @Override
    void observeViewModel() {
        ContestViewModel contestViewModel = ViewModelProviders.of(this, mFactory).get(ContestViewModel.class);
        contestViewModel.getContests().observe(this, this::updateContests);
    }

    protected void updateContests(@NonNull List<Contest> aContests) {
        aContests.sort(Collections
                .reverseOrder((o1, o2) -> Integer.compare(o1.getStartTimeSeconds(), o2.getStartTimeSeconds())));
        mAdapter.setContests(aContests);
        mAdapter.notifyDataSetChanged();
    }
}
