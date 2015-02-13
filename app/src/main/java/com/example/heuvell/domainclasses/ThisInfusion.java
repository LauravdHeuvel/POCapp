package com.example.heuvell.domainclasses;

/**
 * Created by HeuvelL on 12-2-2015.
 */
public class ThisInfusion {

    private int thisInfusionNumber;
    private int infusionNumber;
    private int patientEPDNumber;
    private int infusionDuration;

    public ThisInfusion(){}

    public ThisInfusion(int thisInfusionNumber, int infusionNumber, int patientEPDNumber, int infusionDuration){
        this.thisInfusionNumber = thisInfusionNumber;
        this.infusionNumber = infusionNumber;
        this.patientEPDNumber = patientEPDNumber;
        this.infusionDuration = infusionDuration;
    }

    public int getThisInfusionNumber() {
        return thisInfusionNumber;
    }

    public void setThisInfusionNumber(int thisInfusionNumber) {
        this.thisInfusionNumber = thisInfusionNumber;
    }

    public int getInfusionNumber() {
        return infusionNumber;
    }

    public void setInfusionNumber(int infusionNumber) {
        this.infusionNumber = infusionNumber;
    }

    public int getPatientEPDNumber() {
        return patientEPDNumber;
    }

    public void setPatientEPDNumber(int patientEPDNumber) {
        this.patientEPDNumber = patientEPDNumber;
    }

    public int getInfusionDuration() {
        return infusionDuration;
    }

    public void setInfusionDuration(int infusionDuration) {
        this.infusionDuration = infusionDuration;
    }
}
