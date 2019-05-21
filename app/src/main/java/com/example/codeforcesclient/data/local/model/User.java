package com.example.codeforcesclient.data.local.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.net.URL;

/**
 * Immutable model class for a User.
 */
@Entity(tableName = "user")
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

    @NonNull
    public String getUserHandle() {
        return mUserHandle;
    }

    @Nullable
    public String getEmail() {
        return mEmail;
    }

    @Nullable
    public String getVkId() {
        return mVkId;
    }

    @Nullable
    public String getOpenId() {
        return openId;
    }

    @Nullable
    public String getFirstName() {
        return firstName;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    @Nullable
    public String getCountry() {
        return country;
    }

    @Nullable
    public String getCity() {
        return city;
    }

    @Nullable
    public String getOrganization() {
        return organization;
    }

    @Nullable
    public String getRank() {
        return rank;
    }

    @Nullable
    public String getMaxRank() {
        return maxRank;
    }

    public int getContribution() {
        return contribution;
    }

    public int getRating() {
        return rating;
    }

    public int getMaxRating() {
        return maxRating;
    }

    public long getLastOnlineTimeSeconds() {
        return lastOnlineTimeSeconds;
    }

    public long getLastRegistrationTimeSeconds() {
        return lastRegistrationTimeSeconds;
    }

    public int getFriendCount() {
        return friendCount;
    }

    @NonNull
    public URL getAvatar() {
        return avatar;
    }

    @NonNull
    public URL getTitlePhoto() {
        return titlePhoto;
    }
}
