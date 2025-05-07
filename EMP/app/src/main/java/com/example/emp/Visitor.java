package com.example.employee;

import java.io.Serializable;

public class Visitor implements Serializable {

    private String name;
    private String email;
    private String phone;
    private String inTime;
    private String outTime;

    // Constructor
    public Visitor(String name, String email, String phone, String inTime, String outTime) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getInTime() {
        return inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }
}
