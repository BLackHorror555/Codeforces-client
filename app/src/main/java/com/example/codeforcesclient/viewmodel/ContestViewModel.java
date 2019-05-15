package com.example.codeforcesclient.viewmodel;

import com.example.codeforcesclient.data.local.model.Contest;
import com.example.codeforcesclient.data.repository.ContestRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContestViewModel extends ViewModel {

    private MutableLiveData<List<Contest>> contests;

    @Inject
    public ContestViewModel(@NonNull ContestRepository aContestRepository) {
        contests = (MutableLiveData<List<Contest>>) aContestRepository.getContests();
    }

    public LiveData<List<Contest>> getContests() {
        return contests;
    }
}
