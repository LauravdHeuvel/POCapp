package com.example.heuvell.domainclasses;

import java.sql.Time;
import java.util.Date;

/**
 * Created by HeuvelL on 18-2-2015.
 */
public class Alert {
    private int alertNumber;
    private int nurseNumber;
    private Date date;
    private String time;
    private String content;


    public Alert(){

    }

    public Alert(int alertNumber, int nurseNumber, Date date, String time, String content ){

        this.nurseNumber = nurseNumber;
        this.alertNumber = alertNumber;
        this.date = date;
        this.time = time;
        this.content = content;
    }



    public int getNurseNumber() {
        return nurseNumber;
    }

    public void setNurseNumber(int nurseNumber) {
        this.nurseNumber = nurseNumber;
    }

    public int getAlertNumber() {
        return alertNumber;
    }

    public void setAlertNumber(int alertNumber) {
        this.alertNumber = alertNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
