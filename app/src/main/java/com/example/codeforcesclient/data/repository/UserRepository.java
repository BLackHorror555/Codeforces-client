package com.example.codeforcesclient.data.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.codeforcesclient.data.local.dao.UserDao;
import com.example.codeforcesclient.data.local.model.User;
import com.example.codeforcesclient.data.remote.CodeForcesResponse;
import com.example.codeforcesclient.data.remote.service.UserService;
import com.example.codeforcesclient.utils.LoadExecutors;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository extends BaseRepository {

    private static final String TAG = "UserRepository";
    private final UserDao mUserDao;
    private UserService mUserService;

    @Inject
    UserRepository(UserDao aUserDao, UserService aUserService, LoadExecutors aLoadExecutors) {
        super(aLoadExecutors);
        mUserDao = aUserDao;
        mUserService = aUserService;
    }

    public LiveData<List<User>> getRatedUsers() {
        if (!isCashed()) {
            fetchRatedUsers();
            setCashed(true);
        }

        return mUserDao.loadAll();
    }

    public LiveData<User> getUser(String aUserHandle) {
        LiveData<User> user = mUserDao.loadUser(aUserHandle);
        if (user.getValue() == null) {
            user = fetchUser(aUserHandle);
        }

        return user;
    }

    private MutableLiveData<User> fetchUser(String aUserHandle) {
        MutableLiveData<User> user = new MutableLiveData<>();
        Call<CodeForcesResponse<List<User>>> aUserCall = mUserService.getUsers(aUserHandle);
        aUserCall.enqueue(new Callback<CodeForcesResponse<List<User>>>() {
            @Override
            public void onResponse(Call<CodeForcesResponse<List<User>>> call, Response<CodeForcesResponse<List<User>>> response) {
                if (response.body() != null) {
                    user.setValue(response.body().getResult().get(0));
                }
            }

            @Override
            public void onFailure(Call<CodeForcesResponse<List<User>>> call, Throwable t) {
                Log.w(TAG, "Failed to load user from server: " + t);
                user.setValue(null);
            }
        });

        return user;
    }

    private void fetchRatedUsers() {
        Call<CodeForcesResponse<List<User>>> aUserCall = mUserService.getRatedUserList(true);
        aUserCall.enqueue(new Callback<CodeForcesResponse<List<User>>>() {
            @Override
            public void onResponse(@NonNull Call<CodeForcesResponse<List<User>>> call,
                                   @NonNull Response<CodeForcesResponse<List<User>>> response) {
                if (response.body() != null) {
                    executeLocal(() -> mUserDao.updateData(response.body().getResult()));
                }
            }

            @Override
            public void onFailure(Call<CodeForcesResponse<List<User>>> call, Throwable t) {
                Log.w(TAG, "Failed to load user rating from server: " + t);

            }
        });

    }
}
