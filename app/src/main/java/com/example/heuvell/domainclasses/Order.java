package com.example.heuvell.domainclasses;

import java.util.Date;

/**
 * Created by HeuvelL on 18-2-2015.
 */
public class Order {
    private int orderNumber;
    private int foodNumber;
    private int patientNumber;
    private Date date;
    private int eaten;

    public Order(){

    }

    public Order(int orderNumber, int foodNumber, int patientNumber, Date date, int eaten){
        this.orderNumber = orderNumber;
        this.foodNumber = foodNumber;
        this.patientNumber = patientNumber;
        this.date = date;
        this.eaten = eaten;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int thisOrderNumber) {
        this.orderNumber = thisOrderNumber;
    }

    public int getFoodNumber() {
        return foodNumber;
    }

    public void setFoodNumber(int foodNumber) {
        this.foodNumber = foodNumber;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEaten() {
        return eaten;
    }

    public void setEaten(int eaten) {
        this.eaten = eaten;
    }
}
