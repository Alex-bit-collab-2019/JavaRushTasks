package com.javarush.task.task14.task1417;

abstract class Money {
    private double amount;
    public abstract String getCurrencyName();

    public Money(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}