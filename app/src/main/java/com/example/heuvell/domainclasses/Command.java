package com.example.heuvell.domainclasses;

import java.sql.Date;

/**
 * Created by HeuvelL on 10-2-2015.
 */
public class Command {

    private int commandNumber;
    private int nurseNumber;
    private int employeeNumber;
    private String content;
    private Date date;

    public Command(){

    }

    public Command(int commandNumber, int nurseNumber, int employeeNumber, String content, Date date){
        this.commandNumber = commandNumber;
        this.nurseNumber = nurseNumber;
        this.employeeNumber = employeeNumber;
        this.content = content;
        this.date = date;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public void setCommandNumber(int commandNumber) {
        this.commandNumber = commandNumber;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
