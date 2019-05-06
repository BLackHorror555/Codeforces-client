package com.example.codeforcesclient.data.local.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "problem")
public class Problem {

    @IntDef({Problemtype.PROGRAMMING, Problemtype.QUESTION})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Problemtype {
        int PROGRAMMING = 0;
        int QUESTION = 1;
    }

    private int contestId;

    @Nullable
    private String problemsetName;

    @PrimaryKey
    @NonNull
    private String index;

    @NonNull
    private String name;

    @NonNull
    private Problemtype mProblemtype;

    private float points;

    private int rating;

    @NonNull
    private String[] tags;
}
