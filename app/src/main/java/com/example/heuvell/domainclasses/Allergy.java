package com.example.heuvell.domainclasses;

/**
 * Created by HeuvelL on 10-2-2015.
 */
public class Allergy {
    private int allergyNumber;
    private String allergyName;

    public Allergy(){

    }

    public Allergy(int allergyNumber, String allergyName){
        this.allergyNumber = allergyNumber;
        this.allergyName = allergyName;
    }

    public int getAllergyNumber() {
        return allergyNumber;
    }

    public void setAllergyNumber(int allergyNumber) {
        this.allergyNumber = allergyNumber;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }
}
