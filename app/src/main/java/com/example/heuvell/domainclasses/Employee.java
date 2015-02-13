package com.example.heuvell.domainclasses;

/**
 * Created by HeuvelL on 10-2-2015.
 */
public class Employee {
    private int employeeNumber;
    private String name;
    private String function;

    public Employee(){

    }

    public Employee(int employeeNumber, String name, String function){
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.function = function;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
