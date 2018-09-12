package com.example.demo.controller;

import com.example.demo.feignInterface.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on  九月
 */
@RestController
public class DcController {

    @Autowired
    private DcClient dcClient;

    @GetMapping("/consumer")
    public String dc(){
        return  dcClient.consumer();
    }

}
