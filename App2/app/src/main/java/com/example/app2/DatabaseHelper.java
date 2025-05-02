package com.example.app2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "visitors.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "visitors";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_MOBILE = "mobile";
    private static final String COLUMN_IN_TIME = "in_time";
    private static final String COLUMN_OUT_TIME = "out_time";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_MOBILE + " TEXT, " +
                COLUMN_IN_TIME + " TEXT, " +
                COLUMN_OUT_TIME + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Fetch all visitors
    public ArrayList<Visitor> getAllVisitors() {
        ArrayList<Visitor> visitorList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL));
                String mobile = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MOBILE));
                String inTime = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IN_TIME));
                String outTime = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OUT_TIME));

                Visitor visitor = new Visitor(id, name, email, mobile, inTime, outTime);
                visitorList.add(visitor);
            }
            cursor.close();
        }

        return visitorList;
    }

    // Fetch a visitor by ID
    public Visitor getVisitorById(int visitorId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{COLUMN_ID, COLUMN_NAME, COLUMN_EMAIL, COLUMN_MOBILE, COLUMN_IN_TIME, COLUMN_OUT_TIME},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(visitorId)},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL));
            String mobile = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MOBILE));
            String inTime = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IN_TIME));
            String outTime = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OUT_TIME));

            Visitor visitor = new Visitor(visitorId, name, email, mobile, inTime, outTime);
            cursor.close();
            return visitor;
        }

        if (cursor != null) cursor.close();
        return null;
    }

    // Update visitor details
    public boolean updateVisitor(Visitor visitor) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, visitor.getName());
        values.put(COLUMN_EMAIL, visitor.getEmail());
        values.put(COLUMN_MOBILE, visitor.getMobileNumber());
        values.put(COLUMN_IN_TIME, visitor.getInTime());
        values.put(COLUMN_OUT_TIME, visitor.getOutTime());

        int rowsAffected = db.update(TABLE_NAME, values, COLUMN_ID + "=?", new String[]{String.valueOf(visitor.getId())});
        return rowsAffected > 0;
    }
}
