package com.example.heuvell.domainclasses;

/**
 * Created by HeuvelL on 10-2-2015.
 */
public class Nurse {
    private int nurseNumber;
    private String name;
    private String password;
    private int departmentNumber;

    public Nurse(){

    }

    public Nurse(int nurseNumber, String name, String password, int departmentNumber){
        this.nurseNumber = nurseNumber;
        this.name = name;
        this.password = password;
        this.departmentNumber = departmentNumber;
    }

    public int getNurseNumber() {
        return nurseNumber;
    }

    public void setNurseNumber(int nurseNumber) {
        this.nurseNumber = nurseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }
}
