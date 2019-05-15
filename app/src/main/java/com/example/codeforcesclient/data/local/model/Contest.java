package com.example.codeforcesclient.data.local.model;

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

    /*]
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
    private int id;
    private String name;
//    @ContestType
    private int type;
//    @ContestPhase
    private int phase;
    private boolean frosen;
    private int durationSeconds;
    private int startTimeSeconds;
    private int relativeTimeSeconds;
    private String preparedBy;
    private String websiteUrl;
    private String description;
    private int difficulty;
    private String kind;
    private String icpcRegion;
    private String country;
    private String season;

//    public Contest(int aId, @NonNull String aName, @ContestType int aType, @ContestPhase int aPhase,
//                   boolean aFrosen, int aDurationSeconds, int aStartTimeSeconds, int aRelativeTimeSeconds,
//                   String aPreparedBy, String aWebsiteUrl, String aDescription, int aDifficulty, String aKind,
//                   String aIcpcRegion, String aCountry, String aSeason) {
//        id = aId;
//        name = aName;
//        type = aType;
//        phase = aPhase;
//        frosen = aFrosen;
//        durationSeconds = aDurationSeconds;
//        startTimeSeconds = aStartTimeSeconds;
//        relativeTimeSeconds = aRelativeTimeSeconds;
//        preparedBy = aPreparedBy;
//        websiteUrl = aWebsiteUrl;
//        description = aDescription;
//        difficulty = aDifficulty;
//        kind = aKind;
//        icpcRegion = aIcpcRegion;
//        country = aCountry;
//        season = aSeason;
//    }

    public int getId() {
        return id;
    }

    public void setId(int aId) {
        id = aId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String aName) {
        name = aName;
    }

    public int getType() {
        return type;
    }

    public void setType(@NonNull int aType) {
        type = aType;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(@NonNull int aPhase) {
        phase = aPhase;
    }

    public boolean isFrosen() {
        return frosen;
    }

    public void setFrosen(boolean aFrosen) {
        frosen = aFrosen;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int aDurationSeconds) {
        durationSeconds = aDurationSeconds;
    }

    public int getStartTimeSeconds() {
        return startTimeSeconds;
    }

    public void setStartTimeSeconds(int aStartTimeSeconds) {
        startTimeSeconds = aStartTimeSeconds;
    }

    public int getRelativeTimeSeconds() {
        return relativeTimeSeconds;
    }

    public void setRelativeTimeSeconds(int aRelativeTimeSeconds) {
        relativeTimeSeconds = aRelativeTimeSeconds;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String aPreparedBy) {
        preparedBy = aPreparedBy;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String aWebsiteUrl) {
        websiteUrl = aWebsiteUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int aDifficulty) {
        difficulty = aDifficulty;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String aKind) {
        kind = aKind;
    }

    public String getIcpcRegion() {
        return icpcRegion;
    }

    public void setIcpcRegion(String aIcpcRegion) {
        icpcRegion = aIcpcRegion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String aCountry) {
        country = aCountry;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String aSeason) {
        season = aSeason;
    }

    @Override
    public String toString() {
        return "Contest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", phase=" + phase +
                ", frosen=" + frosen +
                ", durationSeconds=" + durationSeconds +
                ", startTimeSeconds=" + startTimeSeconds +
                ", relativeTimeSeconds=" + relativeTimeSeconds +
                ", preparedBy='" + preparedBy + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", description='" + description + '\'' +
                ", difficulty=" + difficulty +
                ", kind='" + kind + '\'' +
                ", icpcRegion='" + icpcRegion + '\'' +
                ", country='" + country + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}