package com.example.app2;

import java.io.Serializable;

public class Visitor implements Serializable {

    private int id;  // Add this line to fix the error
    private String name;
    private String email;
    private String mobileNumber;
    private String inTime;
    private String outTime;

    // Constructor without ID (used when inserting new data)
    public Visitor(String name, String email, String mobileNumber, String inTime, String outTime) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    // Constructor with ID (used when retrieving from database)
    public Visitor(int id, String name, String email, String mobileNumber, String inTime, String outTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getInTime() {
        return inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

}