package com.example.codeforcesclient.data.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.net.URL;

/**
 * Immutable model class for a User.
 */
@Entity(tableName = "users")
public final class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "handle")
    private String mUserHandle;

    @Nullable
    @ColumnInfo(name = "email")
    private String mEmail;

    @Nullable
    @ColumnInfo(name = "vkId")
    private String mVkId;

    @Nullable
    @ColumnInfo(name = "openId")
    private String openId;

    @Nullable
    @ColumnInfo(name = "firstName")
    private String firstName;

    @Nullable
    @ColumnInfo(name = "lastName")
    private String lastName;

    @Nullable
    @ColumnInfo(name = "country")
    private String country;

    @Nullable
    @ColumnInfo(name = "city")
    private String city;

    @Nullable
    @ColumnInfo(name = "organization")
    private String organization;

    @Nullable
    @ColumnInfo(name = "rank")
    private String rank;

    @Nullable
    @ColumnInfo(name = "maxRank")
    private String maxRank;

    @ColumnInfo(name = "contribution")
    private int contribution;

    @ColumnInfo(name = "rating")
    private int rating;

    @ColumnInfo(name = "maxRating")
    private int maxRating;

    @ColumnInfo(name = "lastOnlineTime")
    private long lastOnlineTimeSeconds;

    @ColumnInfo(name = "lastRegistrationTime")
    private long lastRegistrationTimeSeconds;

    @ColumnInfo(name = "friendCount")
    private int friendCount;

    @ColumnInfo(name = "avatar")
    private URL avatar;

    @ColumnInfo(name = "titlePhoto")
    private URL titlePhoto;


    public User() {
    }
}
