package com.example.codeforcesclient.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.codeforcesclient.data.local.model.Contest;
import com.example.codeforcesclient.data.repository.ContestRepository;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class ContestViewModel extends ViewModel {

    private LiveData<List<Contest>> mContests;
    private LiveData<List<Contest>> mGymContests;

    @Inject
    public ContestViewModel(@NonNull ContestRepository aContestRepository) {
        mContests = aContestRepository.getContests();
        mGymContests = aContestRepository.getGymContests();
    }

    public LiveData<List<Contest>> getContests() {
        if (mContests.getValue() != null) {
            sortByStartingTime(mContests.getValue());
        }

        return mContests;
    }

    private List<Contest> sortByStartingTime(List<Contest> aContests) {
        aContests.sort(Collections
                .reverseOrder((o1, o2) -> Integer.compare(o1.getStartTimeSeconds(), o2.getStartTimeSeconds())));

        return aContests;
    }

    public LiveData<List<Contest>> getGymContests() {
        if (mContests.getValue() != null) {
            sortByStartingTime(mContests.getValue());
        }

        return mGymContests;
    }
}
