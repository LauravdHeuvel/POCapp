package com.example.heuvell.domainclasses;

import java.sql.Date;

/**
 * Created by HeuvelL on 10-2-2015.
 */
public class Question {

    private int questionNumber;
    private int nurseNumber;
    private int employeeNumber;
    private String content;
    private Date date;
    private String answer;

    public Question(){

    }

    public Question(int questionNumber, int nurseNumber, int employeeNumber, String content, Date date, String answer){
        this.questionNumber = questionNumber;
        this.nurseNumber = nurseNumber;
        this.employeeNumber = employeeNumber;
        this.content = content;
        this.date = date;
        this.answer = answer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int commandNumber) {
        this.questionNumber = commandNumber;
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




    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
