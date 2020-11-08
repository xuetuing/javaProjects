package com.company.designpattern.strategy.StrategyWithTpl;

public class LogContext {
    public void log(String msg) {
        LogStrategy strategy = new DBLog();
        try {
            strategy.log(msg);
        } catch (Exception e) {
            strategy = new FileLog();
            strategy.log(msg);
        }

    }

}
