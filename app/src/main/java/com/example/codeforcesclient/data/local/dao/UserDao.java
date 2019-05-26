package com.example.codeforcesclient.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.codeforcesclient.data.local.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> aUsers);

    @Query("DELETE FROM user")
    void deleteAll();

    @Query("SELECT * FROM user")
    LiveData<List<User>> loadAll();

    @Transaction
    default void updateData(List<User> aUsers) {
        deleteAll();
        insertAll(aUsers);
    }

    @Query("SELECT * FROM user WHERE handle = :aHandle")
    LiveData<User> loadUser(String aHandle);
}
