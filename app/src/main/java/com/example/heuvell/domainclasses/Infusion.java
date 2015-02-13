package com.example.heuvell.domainclasses;

/**
 * Created by HeuvelL on 10-2-2015.
 */
public class Infusion {
    private int infusionNumber;
    private String infusionName;

    public Infusion(){

    }

    public Infusion(int infusionNumber,  String infusionName){
        this.infusionNumber = infusionNumber;

        this.infusionName = infusionName;


    }

    public int getInfusionNumber() {
        return infusionNumber;
    }

    public void setInfusionNumber(int infusionNumber) {
        this.infusionNumber = infusionNumber;
    }



    public String getInfusionName() {
        return infusionName;
    }

    public void setInfusionName(String infusionName) {
        this.infusionName = infusionName;
    }


}
