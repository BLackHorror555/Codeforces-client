package com.example.codeforcesclient.data.repository;

import android.arch.lifecycle.LiveData;

import com.example.codeforcesclient.data.local.dao.UserDao;
import com.example.codeforcesclient.data.local.entity.User;

import javax.inject.Inject;

public class UserRepository {

    private final UserDao mUserDao;

    @Inject
    UserRepository(UserDao aUserDao) {
        mUserDao = aUserDao;
    }

    public LiveData<User> getUsers() {
        return null;
    }
}
