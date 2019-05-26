package com.example.codeforcesclient.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.codeforcesclient.data.local.model.User;
import com.example.codeforcesclient.data.repository.UserRepository;

import javax.inject.Inject;

public class UserViewModel extends ViewModel {

    private LiveData<User> mUser;
    private MutableLiveData<Boolean> mIsDataAvailable = new MutableLiveData<>();
    private final UserRepository mUserRepository;

    @Inject
    public UserViewModel(@NonNull UserRepository aUserRepository) {
        mUserRepository = aUserRepository;
        mUser = new MutableLiveData<>();
    }

    public void setUserHandle(String aUserHandle) {
        mUser = mUserRepository.getUser(aUserHandle);
        mIsDataAvailable.setValue(mUser != null);
    }

    public LiveData<User> getUser() {
        return mUser;
    }

    public MutableLiveData<Boolean> isDataAvailable() {
        return mIsDataAvailable;
    }
}
