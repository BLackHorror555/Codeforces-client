package com.example.codeforcesclient.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.codeforcesclient.data.local.entity.Contest;

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
    List<Contest> loadAll();

    @Query("SELECT * FROM contests WHERE name LIKE :contestName LIMIT 1")
    Contest findByName(String contestName);

    @Query("SELECT * FROM contests WHERE id = :aId")
    Contest findById(int aId);
}
