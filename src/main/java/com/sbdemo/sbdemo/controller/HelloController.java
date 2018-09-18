package com.sbdemo.sbdemo.controller;

import com.sbdemo.sbdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
public class HelloController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/hello")
    public String hello(){

        redisUtil.set("testname", "jack");
        String username = (String) redisUtil.get("testname");

        return "hello & bye" + username;
    }
}
