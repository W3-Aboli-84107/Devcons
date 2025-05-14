package com.example.empvisitingapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "visitor_table")
public class Visitor implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String visitorName;
    private String employeeName;
    private String email;
    private String mobile;
    private String purpose;
    private String address;
    private String inTime;

    // Constructor, getters, and setters
    public Visitor(String visitorName, String employeeName, String email, String mobile, String purpose, String address, String inTime) {
        this.visitorName = visitorName;
        this.employeeName = employeeName;
        this.email = email;
        this.mobile = mobile;
        this.purpose = purpose;
        this.address = address;
        this.inTime = inTime;
    }

    // Getters and setters for each field
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }
}
