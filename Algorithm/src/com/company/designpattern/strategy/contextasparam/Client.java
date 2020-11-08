package com.company.designpattern.strategy.contextasparam;

public class Client {

    public static void main(String[] args) {
        PayStrategy strategy = new RMBPay();
        PaymentContext context = new PaymentContext("王林", 1000, strategy);
        context.payNow();
    }

}
