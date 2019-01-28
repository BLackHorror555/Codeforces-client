package com.example.codeforcesclient.data.model;

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
    @ColumnInfo(name = "vk_id")
    private String mVkId;

    @Nullable
    @ColumnInfo(name = "open_id")
    private String openId;

    @Nullable
    @ColumnInfo(name = "first_name")
    private String firstName;

    @Nullable
    @ColumnInfo(name = "last_name")
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
    @ColumnInfo(name = "max_rank")
    private String maxRank;

    @NonNull
    @ColumnInfo(name = "contribution")
    private int contribution;

    @NonNull
    @ColumnInfo(name = "rating")
    private int rating;

    @NonNull
    @ColumnInfo(name = "max_rating")
    private int maxRating;

    @NonNull
    @ColumnInfo(name = "last_online_time")
    private long lastOnlineTimeSeconds;

    @NonNull
    @ColumnInfo(name = "last_registration_time")
    private long lastRegistrationTimeSeconds;

    @NonNull
    @ColumnInfo(name = "friend_count")
    private int friendCount;

    @NonNull
    @ColumnInfo(name = "avatar")
    private URL avatar;

    @NonNull
    @ColumnInfo(name = "title_photo")
    private URL titlePhoto;


}
