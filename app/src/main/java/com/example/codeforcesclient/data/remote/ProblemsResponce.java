package com.example.codeforcesclient.data.remote;

import com.example.codeforcesclient.data.local.model.Problem;
import com.example.codeforcesclient.data.local.model.ProblemStatistics;

import java.util.ArrayList;
import java.util.List;

public class ProblemsResponce {
    private List<Problem> problems;
    private List<ProblemStatistics> problemStatistics;

    public ProblemsResponce(List<Problem> aProblems, List<ProblemStatistics> aProblemStatistics) {
        problems = aProblems;
        problemStatistics = aProblemStatistics;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public void setProblems(List<Problem> aProblems) {
        problems = aProblems;
    }

    public List<ProblemStatistics> getProblemStatistics() {
        return problemStatistics;
    }

    public void setProblemStatistics(List<ProblemStatistics> aProblemStatistics) {
        problemStatistics = aProblemStatistics;
    }
}
