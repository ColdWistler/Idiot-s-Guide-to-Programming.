package com.example.genericsfx1.model;

public class Electronics {
    private String name;
    private int warrantyMonths;

    public Electronics(String name, int warrantyMonths) {
        this.name = name;
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String toString() {
        return "Electronics [Name: " + name + ", Warranty: " + warrantyMonths + " months]";
    }
}