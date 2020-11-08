package com.company.designpattern.strategy.normal;

public class OldCustPay implements Strategy{
    @Override
    public double pay(double goodsPrice) {
        System.out.println("老客户享受折扣10%。");
        return goodsPrice * (1 - 0.1);
    }
}
