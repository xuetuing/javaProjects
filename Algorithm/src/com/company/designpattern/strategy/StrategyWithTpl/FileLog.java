package com.company.designpattern.strategy.StrategyWithTpl;

public class FileLog extends LogStrategyTpl {
    @Override
    protected void doLog(String msg) {
        System.out.println("现在将'" + msg + "'打印到文件。");
    }
}
