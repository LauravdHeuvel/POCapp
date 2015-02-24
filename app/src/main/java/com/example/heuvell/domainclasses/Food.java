package com.example.heuvell.domainclasses;

/**
 * Created by HeuvelL on 18-2-2015.
 */
public class Food {
    private int foodNumber;
    private String foodName;
    private int eggsNumber;

    public Food(){

    }

    public Food(int foodNumber, String foodName, int eggsNumber){
        this.foodNumber = foodNumber;
        this.foodName = foodName;
        this.eggsNumber = eggsNumber;
    }

    public int getFoodNumber() {
        return foodNumber;
    }

    public void setFoodNumber(int foodNumber) {
        this.foodNumber = foodNumber;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getEggsNumber() {
        return eggsNumber;
    }

    public void setEggsNumber(int eggsNumber) {
        this.eggsNumber = eggsNumber;
    }
}
