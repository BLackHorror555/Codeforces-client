package com.example.codeforcesclient.data.remote.service;

import com.example.codeforcesclient.data.local.model.Problem;
import com.example.codeforcesclient.data.remote.CodeForcesResponse;
import com.example.codeforcesclient.data.remote.ProblemsResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProblemService {

    @GET("problemset.problems")
    Call<CodeForcesResponse<ProblemsResponce>> getProblems();
}
