package com.example.codeforcesclient.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.codeforcesclient.data.local.dao.ContestDao;
import com.example.codeforcesclient.data.local.dao.UserDao;
import com.example.codeforcesclient.data.local.model.Contest;
import com.example.codeforcesclient.data.local.model.User;

@Database(entities = {Contest.class, User.class}, version = 1)
public abstract class CodeForcesDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public abstract ContestDao contestDao();

}
