package com.example.demo.controller;

import com.example.demo.feignInterface.user.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("user/name")
    public  String getUserName(){
        return userFeignClient.getUserName();
    }

}


