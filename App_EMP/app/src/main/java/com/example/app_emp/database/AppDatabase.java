package com.example.app_emp.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app_emp.dao.UserDao;
import com.example.app_emp.dao.VisitorDao;
import com.example.app_emp.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract UserDao userDao();
    public abstract VisitorDao visitorDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() // Don't use on production
                    .build();
        }
        return instance;
    }
}
