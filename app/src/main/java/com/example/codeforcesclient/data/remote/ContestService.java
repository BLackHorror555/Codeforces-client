package com.example.codeforcesclient.data.remote;

import com.example.codeforcesclient.data.local.entity.Contest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ContestService {

    @GET("contest.list")
    Call<List<Contest>> getContests(@Query("gym") Boolean gym);

}
