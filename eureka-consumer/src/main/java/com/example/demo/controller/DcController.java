package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lenovo on  九月
 */


@RestController
public class DcController {

    @Autowired
    private  LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer")
    public  String dc() {
//        用choose()函数选出一个eureka-client的服务实例，这个服务实例的基本信息存储在ServiceInstance
        ServiceInstance serviceInstance=loadBalancerClient.choose("eureka-client");
        String url="http://"+ serviceInstance.getHost() +":" +serviceInstance.getPort() +"/dc";
        System.out.println(url);
//        通过restTemplate向url发起请求，以String的形式返回数据
        return  restTemplate.getForObject(url,String.class );
    }



}
