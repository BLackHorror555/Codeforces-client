package com.example.codeforcesclient.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.codeforcesclient.data.local.model.Contest;
import com.example.codeforcesclient.data.repository.ContestRepository;

import java.util.List;

import javax.inject.Inject;

public class ContestViewModel extends ViewModel {

    private LiveData<List<Contest>> contests;

    @Inject
    public ContestViewModel(@NonNull ContestRepository aContestRepository) {
        contests = aContestRepository.getContests();
    }

    public LiveData<List<Contest>> getContests() {
        return contests;
    }
}
