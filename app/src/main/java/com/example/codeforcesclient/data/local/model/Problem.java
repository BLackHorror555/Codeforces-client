package com.example.codeforcesclient.data.local.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Entity(tableName = "problem")
public class Problem {

    @StringDef({ProblemType.PROGRAMMING, ProblemType.QUESTION})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProblemType {
        String PROGRAMMING = "PROGRAMMING";
        String QUESTION = "QUESTION";
    }

    private int contestId;

    @Nullable
    private String problemsetName;

    @PrimaryKey
    @NonNull
    private String index;

    @NonNull
    private String name;

    @ProblemType
    private String type;

    private float points;

    private int rating;

    @NonNull
    @Ignore
    private String[] tags;

    private int solvedCount;


    public int getContestId() {
        return contestId;
    }

    public void setContestId(int aContestId) {
        contestId = aContestId;
    }

    @Nullable
    public String getProblemsetName() {
        return problemsetName;
    }

    public void setProblemsetName(@Nullable String aProblemsetName) {
        problemsetName = aProblemsetName;
    }

    @NonNull
    public String getIndex() {
        return index;
    }

    public void setIndex(@NonNull String aIndex) {
        index = aIndex;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String aName) {
        name = aName;
    }

    @ProblemType
    public String getType() {
        return type;
    }

    public void setType(@ProblemType String aType) {
        type = aType;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float aPoints) {
        points = aPoints;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int aRating) {
        rating = aRating;
    }

    @NonNull
    public String[] getTags() {
        return tags;
    }

    public void setTags(@NonNull String[] aTags) {
        tags = aTags;
    }

    public int getSolvedCount() {
        return solvedCount;
    }

    public void setSolvedCount(int aSolvedCount) {
        solvedCount = aSolvedCount;
    }
}
