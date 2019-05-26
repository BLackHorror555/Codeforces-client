package com.example.codeforcesclient.data.local.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Immutable model class for a User.
 */
@Entity(tableName = "user")
public final class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "handle")
    private String handle;

    @Nullable
    @ColumnInfo(name = "email")
    private String email;

    @Nullable
    @ColumnInfo(name = "vk_id")
    private String vkId;

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

    @ColumnInfo(name = "contribution")
    private int contribution;

    @ColumnInfo(name = "rating")
    private int rating;

    @ColumnInfo(name = "max_rating")
    private int maxRating;

    @ColumnInfo(name = "last_online_time")
    private long lastOnlineTimeSeconds;

    @ColumnInfo(name = "last_registration_time")
    private long lastRegistrationTimeSeconds;

    @ColumnInfo(name = "friend_count")
    private int friendOfCount;

    @NonNull
    @ColumnInfo(name = "avatar")
    private String avatar;

    @NonNull
    @ColumnInfo(name = "title_photo")
    private String titlePhoto;

    public String getHandle() {
        return handle;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    @Nullable
    public String getVkId() {
        return vkId;
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

    public int getFriendOfCount() {
        return friendOfCount;
    }

    @NonNull
    public String getAvatar() {
        return avatar;
    }

    @NonNull
    public String getTitlePhoto() {
        return titlePhoto;
    }

    public void setHandle(@NonNull String aHandle) {
        handle = aHandle;
    }

    public void setEmail(@Nullable String aEmail) {
        email = aEmail;
    }

    public void setVkId(@Nullable String aVkId) {
        vkId = aVkId;
    }

    public void setOpenId(@Nullable String aOpenId) {
        openId = aOpenId;
    }

    public void setFirstName(@Nullable String aFirstName) {
        firstName = aFirstName;
    }

    public void setLastName(@Nullable String aLastName) {
        lastName = aLastName;
    }

    public void setCountry(@Nullable String aCountry) {
        country = aCountry;
    }

    public void setCity(@Nullable String aCity) {
        city = aCity;
    }

    public void setOrganization(@Nullable String aOrganization) {
        organization = aOrganization;
    }

    public void setRank(@Nullable String aRank) {
        rank = aRank;
    }

    public void setMaxRank(@Nullable String aMaxRank) {
        maxRank = aMaxRank;
    }

    public void setContribution(int aContribution) {
        contribution = aContribution;
    }

    public void setRating(int aRating) {
        rating = aRating;
    }

    public void setMaxRating(int aMaxRating) {
        maxRating = aMaxRating;
    }

    public void setLastOnlineTimeSeconds(long aLastOnlineTimeSeconds) {
        lastOnlineTimeSeconds = aLastOnlineTimeSeconds;
    }

    public void setLastRegistrationTimeSeconds(long aLastRegistrationTimeSeconds) {
        lastRegistrationTimeSeconds = aLastRegistrationTimeSeconds;
    }

    public void setFriendOfCount(int aFriendOfCount) {
        friendOfCount = aFriendOfCount;
    }

    public void setAvatar(@NonNull String aAvatar) {
        avatar = aAvatar;
    }

    public void setTitlePhoto(@NonNull String aTitlePhoto) {
        titlePhoto = aTitlePhoto;
    }
}
