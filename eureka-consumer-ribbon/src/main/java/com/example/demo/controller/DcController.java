package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lenovo on  九月
 */
@RestController
public class DcController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 用restTemplate进行url请求，通过服务名去访问。。服务提供者的服务名为eureka-client
     * @return
     */
    @GetMapping(value = "/ribbon/consumer")
    public String getClientDc() {
        return   restTemplate.getForObject("http://eureka-client/dc" , String.class);
    }

}
