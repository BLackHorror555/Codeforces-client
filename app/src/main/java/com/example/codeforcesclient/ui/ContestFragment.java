package com.example.codeforcesclient.ui;

import android.os.Bundle;

import com.example.codeforcesclient.viewmodel.ContestViewModel;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class ContestFragment extends Fragment {

//    @Inject
//    ViewModelFactory mFactory;

    private ContestViewModel mContestViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContestViewModel = ViewModelProviders.of(this).get(ContestViewModel.class);
    }
}
