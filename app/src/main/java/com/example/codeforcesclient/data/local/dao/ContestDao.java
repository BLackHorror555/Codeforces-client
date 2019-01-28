package com.example.codeforcesclient.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.codeforcesclient.data.model.Contest;

import java.util.List;

@Dao
public interface ContestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Contest aContest);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Contest> aContests);

    @Delete
    void delete(Contest aContest);

    @Query("DELETE FROM contests")
    void deleteAll();

    @Query("DELETE FROM contests WHERE id = :id")
    void deleteById(int id);

    @Query("SELECT * FROM contests")
    List<Contest> loadALl();

    @Query("SELECT * FROM contests WHERE name LIKE :contestName LIMIT 1")
    Contest findByName(String contestName);

    @Query("SELECT * FROM contests WHERE id = :aId")
    Contest findById(int aId);
}
