package com.example.codeforcesclient.data.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Immutable model class for Contest.
 */
@Entity(tableName = "contests")
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
    @ColumnInfo(name = "contest")
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



}