package com.company.designpattern.strategy.normal;

public class NormalCustPay implements Strategy{
    @Override
    public double pay(double goodsPrice) {
        System.out.println("普通客户无折扣.");
        return goodsPrice;
    }
}
