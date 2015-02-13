package com.example.heuvell.domainclasses;

/**
 * Created by HeuvelL on 10-2-2015.
 */
public class ThisAllergy {


    private int thisAllergyNumber;
    private int allergyNumber;
    private int patientNumber;

    public ThisAllergy(){

    }

    public ThisAllergy(int allergyNumber, int patientNumber, int thisAllergyNumber){
        this.allergyNumber = allergyNumber;
        this.patientNumber = patientNumber;
        this.thisAllergyNumber = thisAllergyNumber;
    }

    public int getThisAllergyNumber() {
        return thisAllergyNumber;
    }

    public void setThisAllergyNumber(int thisAllergyNumber) {
        this.thisAllergyNumber = thisAllergyNumber;
    }

    public int getAllergyNumber() {
        return allergyNumber;
    }

    public int getPatientNumber() {
        return patientNumber;
    }



    public void setAllergyNumber(int allergyNumber) {
        this.allergyNumber = allergyNumber;
    }



    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }
}
