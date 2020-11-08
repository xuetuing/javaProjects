package com.company.designpattern.strategy.contextasparam;

public class PaymentContext {
    private String userName;
    private double money = 0.0;
    private PayStrategy strategy = null;

    public PaymentContext(String userName, double money, PayStrategy strategy) {
        this.userName = userName;
        this.money = money;
        this.strategy = strategy;
    }

    public String getUserName() {
        return userName;
    }

    public double getMoney() {
        return money;
    }

    public void payNow() {
        this.strategy.pay(this);
    }
}
