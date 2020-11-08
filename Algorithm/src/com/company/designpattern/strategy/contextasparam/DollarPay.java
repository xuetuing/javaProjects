package com.company.designpattern.strategy.contextasparam;

public class DollarPay implements PayStrategy{
    @Override
    public void pay(PaymentContext context) {
        System.out.println("现向 " + context.getUserName() + " 支付美元 " + context.getMoney() + " 美元。");

    }
}
