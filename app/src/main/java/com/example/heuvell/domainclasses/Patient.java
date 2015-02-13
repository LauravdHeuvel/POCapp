package com.example.heuvell.domainclasses;

/**
 * Created by HeuvelL on 10-2-2015.
 */
public class Patient {

    private int patientNumber;
    private String name;
    private String address;
    private String recidence;

    public Patient(){

    }

    public Patient(int patientNumber, String name, String address, String recidence){
        this.patientNumber = patientNumber;
        this.name = name;
        this.address = address;
        this.recidence = recidence;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRecidence() {
        return recidence;
    }

    public void setRecidence(String recidence) {
        this.recidence = recidence;
    }
}
