package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.feignInterface.user.UserFeignClient;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsumerUserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @PostMapping("/consumer/user/name/{id}")
    public JSONObject getUserName(@PathVariable("id") Integer id){
        return userFeignClient.getUserNameById(id);
    }

    @PostMapping("/consumer/user")
    public User getUser(@RequestParam("id") Integer id){
        return userFeignClient.getUserById(id);
    }
}


