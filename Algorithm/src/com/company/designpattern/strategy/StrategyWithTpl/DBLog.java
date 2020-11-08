package com.company.designpattern.strategy.StrategyWithTpl;

public class DBLog extends LogStrategyTpl {
    @Override
    protected void doLog(String msg) {
        if(msg != null && msg.trim().length() > 5) {
            int a = 4 / 0;
        }

        System.out.println("现在将'" + msg + "'打印到数据库。");
    }
}
