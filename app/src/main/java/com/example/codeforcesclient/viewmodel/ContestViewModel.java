package com.example.codeforcesclient.viewmodel;

import android.app.Application;

import com.example.codeforcesclient.data.local.CodeForcesDatabase;
import com.example.codeforcesclient.data.local.entity.Contest;
import com.example.codeforcesclient.data.repository.ContestRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ContestViewModel extends AndroidViewModel {

    private LiveData<List<Contest>> availableContests;

    @Inject
    public ContestViewModel(@NonNull Application application, @NonNull ContestRepository aContestRepository) {
        super(application);

        availableContests = aContestRepository.getAvailableContests();
    }

    //expose to UI
    public LiveData<List<Contest>> getAvailableContest() {
        return availableContests;
    }
}
