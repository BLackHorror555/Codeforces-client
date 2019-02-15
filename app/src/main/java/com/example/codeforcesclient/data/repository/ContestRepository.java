package com.example.codeforcesclient.data.repository;

import androidx.lifecycle.LiveData;

import com.example.codeforcesclient.data.local.dao.ContestDao;
import com.example.codeforcesclient.data.local.entity.Contest;

import javax.inject.Inject;

public class ContestRepository {

    private static final int FRESH_TIMOUT_IN_S = 2 * 60;

    private final ContestDao mContestDao;

    @Inject
    public ContestRepository(ContestDao aContestDao) {
        mContestDao = aContestDao;
    }

    public LiveData<Contest> getAvailableContests() {
        return null;
    }


}
