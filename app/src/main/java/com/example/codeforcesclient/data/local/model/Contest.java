package com.example.codeforcesclient.data.local.model;

import androidx.annotation.StringDef;
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
    @StringDef({ContestType.CF, ContestType.IOI, ContestType.ICPC})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ContestType {
        String CF = "CF";
        String IOI = "IOI";
        String ICPC = "ICPC";
    }

    /*]
     * Phase of contest.
     */
    @StringDef({ContestPhase.BEFORE,
            ContestPhase.CODING,
            ContestPhase.PENDING_SYSTEM_TEST,
            ContestPhase.SYSTEM_TEST,
            ContestPhase.FINISHED})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ContestPhase {
        String BEFORE = "BEFORE";
        String CODING = "CODING";
        String PENDING_SYSTEM_TEST = "PENDING_SYSTEM_TEST";
        String SYSTEM_TEST = "SYSTEM_TEST";
        String FINISHED = "FINISHED";
    }

    @PrimaryKey
    private int id;
    private String name;
    @ContestType
    private String type;
    @ContestPhase
    private String phase;
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

    public String getType() {
        return type;
    }

    public void setType(@NonNull String aType) {
        type = aType;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(@NonNull String aPhase) {
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