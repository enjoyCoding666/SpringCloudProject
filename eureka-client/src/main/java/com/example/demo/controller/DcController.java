package com.example.demo.controller;


import com.netflix.discovery.EurekaClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on  九月
 */

@RestController
public class DcController {

    @Autowired
   private DiscoveryClient discoveryClient;


    @GetMapping("/dc")
   public String dc( ) {
       ServiceInstance serviceInstance=discoveryClient.getLocalServiceInstance();
       System.out.println( "ServiceHost："+ serviceInstance.getHost()  );
       return  "service";
   }


}
