package com.example.heuvell.domainclasses;

import java.sql.Date;

/**
 * Created by HeuvelL on 10-2-2015.
 */
public class PatientEPD {
    private int patientEPDNumber;
    private int patientNumber;
    private int nurseNumber;
    private int employeeNumber;
    private Date date;
    private int temperature;
    private String diagnosis;
    private int reanimate;
    private String bloodPressure;
    private int breathing;
    private int pain;
    private int eggsToEat;
    private int eggsEaten;
    private int eggsContent;


    public PatientEPD() {
    }

    public PatientEPD(int patientEPDNumber, int patientNumber, int nurseNumber, int employeeNumber,
                      Date date, int temperature, String diagnose, int reanimate, String bloodPressure, int breathing,
                      int pain, int eggsToEat, int eggsEaten, int eggsContent){
        this.patientEPDNumber = patientEPDNumber;
        this.patientNumber = patientNumber;
        this.nurseNumber = nurseNumber;
        this.employeeNumber = employeeNumber;
        this.date = date;
        this.temperature = temperature;
        this.diagnosis = diagnose;
        this.reanimate = reanimate;
        this.bloodPressure = bloodPressure;
        this.breathing = breathing;
        this.pain = pain;
        this.eggsToEat = eggsToEat;
        this.eggsEaten = eggsEaten;
        this.eggsContent = eggsContent;


    }



    public int getPatientEPDNumber() {
        return patientEPDNumber;
    }

    public void setPatientEPDNumber(int patientEPDNumber) {
        this.patientEPDNumber = patientEPDNumber;
    }

    public int getPatientNumber() {

        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }

    public int getNurseNumber() {

        return nurseNumber;
    }

    public void setNurseNumber(int nurseNumber) {
        this.nurseNumber = nurseNumber;
    }

    public int getEmployeeNumber() {

        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getBreathing() {
        return breathing;
    }

    public void setBreathing(int breathing) {
        this.breathing = breathing;
    }

    public int getPain() {
        return pain;
    }

    public void setPain(int pain) {
        this.pain = pain;
    }

    public int getEggsToEat() {
        return eggsToEat;
    }

    public void setEggsToEat(int eggsToEat) {
        this.eggsToEat = eggsToEat;
    }

    public int getEggsEaten() {
        return eggsEaten;
    }

    public void setEggsEaten(int eggsEaten) {
        this.eggsEaten = eggsEaten;
    }

    public int getEggsContent() {
        return eggsContent;
    }

    public void setEggsContent(int eggsContent) {
        this.eggsContent = eggsContent;
    }
}
