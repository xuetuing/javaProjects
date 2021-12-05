package com.wtj;

import java.text.SimpleDateFormat;
//微秒时间戳的获取方式
public enum MicroTimestamp {
    INSTANCE ;

    private long              startDate ;
    private long              startNanoseconds ;
    private SimpleDateFormat dateFormat ;

    private MicroTimestamp()
    {  this.startDate = System.currentTimeMillis() ;
        this.startNanoseconds = System.nanoTime() ;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") ;
    }

    public String get()
    {  long microSeconds = (System.nanoTime() - this.startNanoseconds) / 1000 ;
        long date = this.startDate + (microSeconds/1000) ;
        return this.dateFormat.format(date) + String.format("%03d", microSeconds % 1000) ;
    }
}
