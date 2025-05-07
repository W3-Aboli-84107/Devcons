package com.example.empvisitor.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "visitor_table") // Define the table name
public class Visitor implements Serializable {

    @PrimaryKey(autoGenerate = true) // Define the primary key and set auto-generation for ID
    private int id;

    private String name;
    private String email;
    private String mobile;
    private String inTime;
    private String outTime;
    private String purpose;

    // Constructor
    public Visitor(String name, String email, String mobile, String inTime, String outTime, String purpose) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.inTime = inTime;
        this.outTime = outTime;
        this.purpose = purpose;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
