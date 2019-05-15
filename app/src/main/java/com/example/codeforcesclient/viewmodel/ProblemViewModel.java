package com.example.codeforcesclient.viewmodel;

import com.example.codeforcesclient.data.local.model.Problem;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class ProblemViewModel extends ViewModel {
    private LiveData<List<Problem>> problems;

    public LiveData<List<Problem>> getProblems() {
        return problems;
    }
}
