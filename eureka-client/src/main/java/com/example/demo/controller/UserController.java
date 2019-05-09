package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

        @GetMapping("/user/name")
        public void getUserName( ) throws Exception {
            System.out.println("==================================================================>getUserName( )");
            throw  new Exception("getUserNameException");
        }



}
