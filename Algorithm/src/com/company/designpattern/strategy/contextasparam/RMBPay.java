package com.company.designpattern.strategy.contextasparam;

public class RMBPay implements PayStrategy{
    @Override
    public void pay(PaymentContext context) {
        System.out.println("现向 " + context.getUserName() + " 支付人民币 " + context.getMoney() + " 元。");
    }
}
