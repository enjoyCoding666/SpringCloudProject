package com.example.demo;

import com.netflix.discovery.shared.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *   @EnableDiscoveryClient 注解用来将当前应用加入到服务治理体系中。
 */

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConsumerApplication {

    /**
     *   RestTemplate，用来真正发起REST请求
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return  new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaConsumerApplication.class).web(true).run(args);
    }
}
