package com.example.codeforcesclient.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.codeforcesclient.data.local.model.User;
import com.example.codeforcesclient.data.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

public class UserListViewModel extends ViewModel {

    private LiveData<List<User>> mUsers;

    @Inject
    public UserListViewModel(@NonNull UserRepository aUserRepository) {
        mUsers = aUserRepository.getRatedUsers();
    }

    public LiveData<List<User>> getRatedUsers() {
        return mUsers;
    }
}
