package com.example.genericsfx1.model;

public class Food {
    private String name;
    private String expiryDate;

    public Food(String name, String expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Food [Name: " + name + ", Expiry Date: " + expiryDate + "]";
    }
}