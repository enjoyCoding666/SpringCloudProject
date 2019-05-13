package com.example.demo.feignInterface.user;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *  使用fallbackFactory捕获异常，并进行服务降级。
 */
@FeignClient(value = "eureka-client",fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {

    @PostMapping(value = "/user/name/{id}")
    JSONObject getUserNameById(@PathVariable("id") Integer id);

    @PostMapping(value = "/user")
    User getUserById(@RequestParam("id") Integer id);
}
