package com.example.codeforcesclient.data.repository;

import com.example.codeforcesclient.data.local.dao.ContestDao;
import com.example.codeforcesclient.data.local.entity.Contest;
import com.example.codeforcesclient.data.remote.ContestService;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;

public class ContestRepository {

    private ContestService mContestService;

    private static final int FRESH_TIMOUT_IN_S = 2 * 60;

    private final ContestDao mContestDao;

    @Inject
    public ContestRepository(ContestDao aContestDao) {
        mContestDao = aContestDao;
    }

    public LiveData<List<Contest>> getAvailableContests() {
//        final MutableLiveData<Contest> contests = new MutableLiveData<>();

        return null;
    }


}
