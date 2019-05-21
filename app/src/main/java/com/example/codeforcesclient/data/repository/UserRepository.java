package com.example.codeforcesclient.data.repository;

import androidx.lifecycle.LiveData;

import com.example.codeforcesclient.data.local.dao.UserDao;
import com.example.codeforcesclient.data.local.model.User;
import com.example.codeforcesclient.data.remote.service.UserService;

import javax.inject.Inject;

public class UserRepository {

    private final UserDao mUserDao;
    private UserService mUserService;


    @Inject
    UserRepository(UserDao aUserDao) {
        mUserDao = aUserDao;
    }

    public LiveData<User> getUsers() {
        return null;
    }
}
