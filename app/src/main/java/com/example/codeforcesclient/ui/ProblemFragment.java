package com.example.codeforcesclient.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.codeforcesclient.R;
import com.example.codeforcesclient.data.local.model.Problem;
import com.example.codeforcesclient.di.Injectable;
import com.example.codeforcesclient.ui.adapters.ProblemAdapter;
import com.example.codeforcesclient.ui.adapters.ProblemClickListener;
import com.example.codeforcesclient.viewmodel.ProblemListViewModel;

import java.util.Collections;
import java.util.List;

public class ProblemFragment extends BaseRecycleViewFragment<ProblemAdapter> implements Injectable {

    private ProblemClickListener mProblemClickListener = aProblem -> {
        ((MainActivity) getActivity()).showFragmentWithBackStack(new ProblemDetailFragment(aProblem));
    };

    @Override
    protected ProblemAdapter createAdapter() {
        return new ProblemAdapter(Collections.emptyList(), mProblemClickListener);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_problem_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recycle_view_problems);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    void observeViewModel() {
        ProblemListViewModel mProblemListViewModel = ViewModelProviders.of(this, mFactory).get(ProblemListViewModel.class);
        mProblemListViewModel.getProblems().observe(this, this::updateProblems);
    }

    protected void updateProblems(List<Problem> aProblems) {
        mAdapter.setProblems(aProblems);
        mAdapter.notifyDataSetChanged();
    }
}
