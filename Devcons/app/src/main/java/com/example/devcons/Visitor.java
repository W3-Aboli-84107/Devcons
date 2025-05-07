package com.example.emp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Visitor_table")
public class Visitor {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String email;
    private String phone;
    private String intime;
    private String outtime;

    public Visitor(String name, String email, String phone, String intime, String outtime) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.intime = intime;
        this.outtime = outtime;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }
}
