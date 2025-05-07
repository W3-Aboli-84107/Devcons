package com.example.empvisitor;

import java.io.Serializable;

public class Visitor implements Serializable {
    private String name, mobile, email, purpose, inTime, outTime;

    public Visitor(String name, String mobile, String email, String purpose, String inTime, String outTime) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.purpose = purpose;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    // Getters
    public String getName() { return name; }
    public String getMobile() { return mobile; }
    public String getEmail() { return email; }
    public String getPurpose() { return purpose; }
    public String getInTime() { return inTime; }
    public String getOutTime() { return outTime; }

    // Setters if needed
}
