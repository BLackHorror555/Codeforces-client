package com.example.codeforcesclient.data.local.model;

public class ProblemStatistics {

    private int contestId;
    private String index;
    private int solvedCount;

    public ProblemStatistics(int aContestId, String aIndex, int aSolvedCount) {
        contestId = aContestId;
        index = aIndex;
        solvedCount = aSolvedCount;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int aContestId) {
        contestId = aContestId;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String aIndex) {
        index = aIndex;
    }

    public int getSolvedCount() {
        return solvedCount;
    }

    public void setSolvedCount(int aSolvedCount) {
        solvedCount = aSolvedCount;
    }
}
