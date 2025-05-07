package com.example.emp.data;

import android.content.Context;

import com.example.emp.Visitor;

@Database(entities = {Visitor.class}, version = 1, expertSchema = false)
public class visitorDatabase extends RoomDatabase
{
    private static visitorDatabase INSTANCE;

    public abstract VisitorDao visitorDao();

    public static synchronized visitorDatabase getInstance(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    visitorDatabase.class, "Visitor_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
