package com.expensetracker;

public class Entry {
    private double amount;
    private String category;
    private String date;

    public Entry(double amount, String category, String date){
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public double getAmount(){
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString(){
        return "Amount: " + amount + ", Category: " + category + ", Date: " + date;
    }
}
