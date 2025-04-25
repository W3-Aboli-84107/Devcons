package com.example.app2;

public class Employee {
    private String name;
    private String email;
    private String mobile;
    private String inTime;
    private String outTime;

    public Employee(String name, String email, String mobile, String inTime, String outTime) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public String getInTime() { return inTime; }
    public String getOutTime() { return outTime; }
}
