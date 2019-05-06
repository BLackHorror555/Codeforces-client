package com.example.codeforcesclient.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Immutable model class for Contest.
 */
@Entity(tableName = "contest")
public class Contest {
    /**
     * Type of contest.
     */
    @IntDef({ContestType.CF, ContestType.IOI, ContestType.ICPC})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ContestType {
        int CF = 0;
        int IOI = 1;
        int ICPC = 2;
    }

    /**
     * Phase of contest.
     */
    @IntDef({ContestPhase.BEFORE,
            ContestPhase.CODING,
            ContestPhase.PENDING_SYSTEM_TEST,
            ContestPhase.SYSTEM_TEST,
            ContestPhase.FINISHED})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ContestPhase {
        int BEFORE = 0;
        int CODING = 1;
        int PENDING_SYSTEM_TEST = 2;
        int SYSTEM_TEST = 3;
        int FINISHED = 4;
    }

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int mId;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "type")
    private ContestType mType;

    @NonNull
    @ColumnInfo(name = "phase")
    private ContestPhase mPhase;

    @ColumnInfo(name = "frosen")
    private boolean frosen;

    @ColumnInfo(name = "duration")
    private int durationSeconds;

    public int getId() {
        return mId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public ContestType getType() {
        return mType;
    }

    @NonNull
    public ContestPhase getPhase() {
        return mPhase;
    }

    public boolean isFrosen() {
        return frosen;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }
}