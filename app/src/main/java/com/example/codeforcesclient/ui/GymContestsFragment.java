package com.example.codeforcesclient.ui;

import androidx.lifecycle.ViewModelProviders;

import com.example.codeforcesclient.viewmodel.ContestViewModel;

public class GymContestsFragment extends ContestFragment {
    @Override
    void observeViewModel() {
        ContestViewModel contestViewModel = ViewModelProviders.of(this, mFactory).get(ContestViewModel.class);
        contestViewModel.getGymContests().observe(this, this::updateContests);
    }
}
