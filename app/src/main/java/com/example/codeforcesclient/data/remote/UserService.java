package com.example.codeforcesclient.data.remote;

import com.example.codeforcesclient.data.local.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {

    @GET("user.info")
    Call<List<User>> getUsers(@Query("handles") String handles);
}
