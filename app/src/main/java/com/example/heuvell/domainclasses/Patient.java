package com.example.heuvell.domainclasses;

/**
 * Created by HeuvelL on 10-2-2015.
 */
public class Patient {

    private int patientNumber;
    private String name;
    private String address;
    private String recidence;
    private String diagnosis;
    private int reanimate;
    private int roomNumber;
    private int department;

    public Patient(){

    }

    public Patient(int patientNumber, String name, String address, String recidence, String diagnosis,
                    int reanimate, int roomNumber, int department){
        this.patientNumber = patientNumber;
        this.name = name;
        this.address = address;
        this.recidence = recidence;
        this.diagnosis = diagnosis;
        this.reanimate = reanimate;
        this.roomNumber = roomNumber;
        this.department = department;
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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getReanimate() {
        return reanimate;
    }

    public void setReanimate(int reanimate) {
        this.reanimate = reanimate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
