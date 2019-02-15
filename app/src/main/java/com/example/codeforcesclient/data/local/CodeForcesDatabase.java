package com.example.codeforcesclient.data.local;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.example.codeforcesclient.data.local.dao.ContestDao;
import com.example.codeforcesclient.data.local.dao.UserDao;
import com.example.codeforcesclient.data.local.entity.Contest;
import com.example.codeforcesclient.data.local.entity.User;

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
