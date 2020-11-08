package com.company.designpattern.strategy.StrategyWithTpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class LogStrategyTpl implements LogStrategy{
    @Override
    public void log(String msg) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        msg = df.format(new Date()) + " 内容是：" + msg;
        doLog(msg);
    }

    protected abstract void doLog(String msg);
}
