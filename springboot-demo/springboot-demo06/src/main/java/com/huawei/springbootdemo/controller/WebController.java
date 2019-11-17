package com.huawei.springbootdemo.controller;

import com.huawei.springbootdemo.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/web")
public class WebController {

    private static final Logger log = LoggerFactory.getLogger(WebController.class);
    @RequestMapping(value = "index")
    public String index(ModelMap map){
        log.debug("this is debug level...");
        map.put("title", "thymeleaf template test.");
        return "index";
    }

    @RequestMapping(value = "error")
    public String error(ModelMap map) {
        throw new RuntimeException("测试异常");
    }

}
