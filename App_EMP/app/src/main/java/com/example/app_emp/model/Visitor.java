package com.example.app_emp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "visitors")
public class Visitor {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "mobile")
    public String mobile;

    @ColumnInfo(name = "purpose")
    public String purpose;

    @ColumnInfo(name = "in_time")
    public String inTime;

    @ColumnInfo(name = "out_time")
    public String outTime;

    public Visitor(String name, String email, String mobile, String purpose, String inTime, String outTime) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.purpose = purpose;
        this.inTime = inTime;
        this.outTime = outTime;
    }
}
