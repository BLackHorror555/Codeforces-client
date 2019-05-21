package com.example.codeforcesclient.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codeforcesclient.R;
import com.example.codeforcesclient.data.local.model.Contest;
import com.example.codeforcesclient.di.Injectable;
import com.example.codeforcesclient.ui.adapters.ContestsAdapter;
import com.example.codeforcesclient.viewmodel.ContestViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ContestFragment extends Fragment implements Injectable {

    private RecyclerView mContestRecycleView;
    private ContestsAdapter mContestsAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Inject
    ViewModelProvider.Factory mFactory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contest, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContestRecycleView = view.findViewById(R.id.recycle_view_contests);
        setupContestRecycleView();
    }

    private void setupContestRecycleView() {
        mContestsAdapter = new ContestsAdapter(new ArrayList<Contest>());
        mContestRecycleView.setAdapter(mContestsAdapter);
        mLayoutManager = new LinearLayoutManager(getContext());
        mContestRecycleView.setLayoutManager(mLayoutManager);
        mContestRecycleView.setHasFixedSize(true);
        mContestRecycleView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ContestViewModel contestViewModel = ViewModelProviders.of(this, mFactory).get(ContestViewModel.class);
        contestViewModel.getContests().observe(this, this::updateContests);
    }

    private void updateContests(@NonNull List<Contest> aContests) {
        mContestsAdapter.setContests(aContests);
        mContestsAdapter.notifyDataSetChanged();
    }
}
