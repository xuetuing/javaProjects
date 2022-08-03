package com.huawei.seckill.common.exception;

import com.huawei.seckill.common.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 */
@RestControllerAdvice
public class RrExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(RrExceptionHandler.class);

    @ExceptionHandler(RrException.class)
    public Result handleRrException(RrException e){
        Result result = new Result();

        return null;
    }

}
