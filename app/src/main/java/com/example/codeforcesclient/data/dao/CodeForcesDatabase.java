package com.example.codeforcesclient.data.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.codeforcesclient.data.local.dao.ContestDao;
import com.example.codeforcesclient.data.local.dao.UserDao;
import com.example.codeforcesclient.data.model.Contest;
import com.example.codeforcesclient.data.model.User;

@Database(entities = {User.class, Contest.class}, version = 1)
public abstract class CodeForcesDatabase extends RoomDatabase {

    private static CodeForcesDatabase sInstance;

    public abstract UserDao userDao();

    public abstract ContestDao contestDao();

    /**
     * @param aContext Application context.
     * @return {@link CodeForcesDatabase} singleton instance.
     */
    public static CodeForcesDatabase getInstance(final Context aContext) {
        if (null == sInstance) {
            sInstance = Room.databaseBuilder(aContext.getApplicationContext(),
                    CodeForcesDatabase.class, "CodeForcesDatabase.db")
                    //TODO: no destructive migration
                    .fallbackToDestructiveMigration().build();
        }
        return sInstance;
    }
}
