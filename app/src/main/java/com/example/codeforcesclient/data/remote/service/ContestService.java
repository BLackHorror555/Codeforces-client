package com.example.codeforcesclient.data.remote.service;

import com.example.codeforcesclient.data.local.model.Contest;
import com.example.codeforcesclient.data.remote.CodeForcesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ContestService {

    @GET("contest.list")
    Call<CodeForcesResponse<List<Contest>>> getContests(@Query("gym") Boolean gym);
}
