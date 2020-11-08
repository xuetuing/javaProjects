package com.company.designpattern.strategy.normal;

public class Context {
    private Strategy strategy = null;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double quote(double goodsPrice) {
        return  this.strategy.pay(goodsPrice);
    }
}
