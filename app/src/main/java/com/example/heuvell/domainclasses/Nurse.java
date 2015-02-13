package com.example.heuvell.domainclasses;

/**
 * Created by HeuvelL on 10-2-2015.
 */
public class Nurse {
    private int nurseNumber;
    private String name;
    private String password;

    public Nurse(){

    }

    public Nurse(int nurseNumber, String name, String password){
        this.nurseNumber = nurseNumber;
        this.name = name;
        this.password = password;
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
}
