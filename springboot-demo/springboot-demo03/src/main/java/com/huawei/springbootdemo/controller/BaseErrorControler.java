package com.huawei.springbootdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "error")
public class BaseErrorControler implements ErrorController {

    private static final Logger log = LoggerFactory.getLogger(BaseErrorControler.class);
    @Override
    public String getErrorPath() {
        log.info("出错啦！进入自定义错误控制器");
        return "common/error";
    }

    @RequestMapping
    public String getError(){
        return getErrorPath();
    }
}
