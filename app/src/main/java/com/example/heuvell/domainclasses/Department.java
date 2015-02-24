package com.example.heuvell.domainclasses;

/**
 * Created by HeuvelL on 18-2-2015.
 */
public class Department {
    private int departmentNumber;
    private String departmentName;
    private String location;

    public Department(){

    }

    public Department(int departmentNumber, String departmentName, String location){
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
        this.location = location;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
