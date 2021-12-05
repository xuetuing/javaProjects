package com.wtj;

import ch.qos.logback.classic.pattern.DateConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class LogDateConvert extends DateConverter {
    @Override
    public String convert(ILoggingEvent le) {
        String date = MicroTimestamp.INSTANCE.get();
        System.out.println("test date: " + date);
        return date;
    }
}
