package com.example.demo.feignInterface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by lenovo on  九月
 */

/**
 * 使用@FeignClient注解。其中的value指定这个接口所要调用的服务名称，fallback指定hystrix的回调类
 * 接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口
 */
@FeignClient(value = "eureka-client",fallback = ClientHystrix.class)
public interface DcClient {
     @GetMapping(value = "/dc")
     String consumer();
}
