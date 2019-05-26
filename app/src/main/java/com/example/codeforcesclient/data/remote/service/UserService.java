package com.example.codeforcesclient.data.remote.service;

import com.example.codeforcesclient.data.local.model.User;
import com.example.codeforcesclient.data.remote.CodeForcesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {

    @GET("user.info")
    Call<CodeForcesResponse<List<User>>> getUsers(@Query("handles") String handles);

    @GET("user.ratedList")
    Call<CodeForcesResponse<List<User>>> getRatedUserList(@Query("activeOnly") Boolean activeOnly);
}
