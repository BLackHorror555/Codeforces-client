package com.example.codeforcesclient.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.codeforcesclient.R;
import com.example.codeforcesclient.data.local.model.Contest;
import com.example.codeforcesclient.di.Injectable;
import com.example.codeforcesclient.viewmodel.ContestViewModel;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

public class ContestFragment extends Fragment implements Injectable {

    RecyclerView mContestRecycleView;

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
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ContestViewModel contestViewModel = ViewModelProviders.of(this, mFactory).get(ContestViewModel.class);
        contestViewModel.getContests().observe(this, this::updateContests);
    }

    private void updateContests(@NonNull List<Contest> aContests) {

    }
}
