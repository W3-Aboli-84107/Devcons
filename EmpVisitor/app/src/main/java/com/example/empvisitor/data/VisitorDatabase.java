//package com.example.empvisitor.data;
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import com.example.empvisitor.dao.VisitorDao;
//import com.example.empvisitor.model.Visitor;
//
//@Database(entities = {Visitor.class}, version = 1, exportSchema = false)
//public abstract class VisitorDatabase extends RoomDatabase {
//
//    private static volatile VisitorDatabase INSTANCE;
//
//    // Abstract DAO method
//    public abstract VisitorDao visitorDao();
//
//    // Singleton pattern to ensure only one instance of the database is created
//    public static VisitorDatabase getInstance(Context context) {
//        if (INSTANCE == null) {
//            synchronized (VisitorDatabase.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                                    VisitorDatabase.class, "visitor_database")
//                            .fallbackToDestructiveMigration()
//                            .build();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//}
package com.example.empvisitor.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.empvisitor.dao.VisitorDao;
import com.example.empvisitor.model.Visitor;

@Database(entities = {Visitor.class}, version = 2, exportSchema = false)
public abstract class VisitorDatabase extends RoomDatabase {

    private static volatile VisitorDatabase INSTANCE;

    public abstract VisitorDao visitorDao();

    public static VisitorDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (VisitorDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    VisitorDatabase.class, "visitor_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
