package com.company.designpattern.strategy.normal;

public class Client {

    public static void main(String[] args) {
        Strategy strategy = new OldCustPay();
        Context context = new Context(strategy);

        double quote = context.quote(1000);
        System.out.println("客户报价：" + quote);
    }

}
