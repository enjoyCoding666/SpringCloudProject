package com.example.demo.feignInterface.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *  使用fallbackFactory捕获异常，并进行服务降级。
 */
@FeignClient(value = "eureka-client",fallbackFactory = UserHystrixFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping(value = "/user/name")
    String getUserName();
}
