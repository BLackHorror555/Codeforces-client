package com.example.codeforcesclient.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.codeforcesclient.data.local.model.Problem;

import java.util.List;

@Dao
public interface ProblemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Problem> aProblems);

    @Query("DELETE FROM problem")
    void deleteAll();

    @Query("SELECT * FROM problem")
    LiveData<List<Problem>> loadAll();

    @Transaction
    default void updateData(List<Problem> aProblems) {
        deleteAll();
        insertAll(aProblems);
    }

    @Query("SELECT * FROM problem WHERE contestId = :aContestId")
    LiveData<List<Problem>> loadProblemsForContest(int aContestId);
}
