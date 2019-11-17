package com.huawei.springbootdemo.controller;

import com.huawei.springbootdemo.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "app")
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping(value = "index")
    public String index(){
        log.debug("this is debug level...");
        log.info("this is info level...");
        return "hello world.";
    }

    @RequestMapping(value = "getmap")
    public Map<String,String> getMap(@RequestParam String name){
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", name);
        map.put("age", "23");
        return map;
    }

    @RequestMapping(value = "/getuser/{id}/{name}")
    public User getUser(@PathVariable int id, @PathVariable String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDate(new Date());
        return user;
    }

}
