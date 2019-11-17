package com.huawei.springbootdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ErrorExceptionHandler.class);

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(RuntimeException runtimeExcep){
        log.info("process runtime exception.");

        ModelAndView mv = new ModelAndView();
        mv.addObject("runtimeExcep", runtimeExcep.getMessage());
        mv.setViewName("error/500");
        return mv;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(Exception exception){
        log.info("process runtime exception.");

        ModelAndView mv = new ModelAndView();
        mv.addObject("runtimeExcep", exception.getMessage());
        mv.setViewName("error/500");
        return mv;
    }
}
