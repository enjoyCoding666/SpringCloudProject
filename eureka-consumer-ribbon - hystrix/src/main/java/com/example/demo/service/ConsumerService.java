package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lenovo on  九月
 */

@Service
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 通过以下url发起请求： http://localhost:4455/ribbon/consumer
     * @HystrixCommand  指定回调方法
     * 如果有服务提供者，能够成功访问，就会直接向服务提供者发起请求。。如果没有就启动回调方法。
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallBack")
    public String getClientDc() {
        return   restTemplate.getForObject("http://eureka-client/dc" , String.class);
    }

    public String fallBack(){
        return "error";
    }

}
