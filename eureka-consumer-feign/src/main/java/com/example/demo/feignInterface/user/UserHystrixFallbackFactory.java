package com.example.demo.feignInterface.user;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 服务降级，
 */
@Slf4j
@Component
public class UserHystrixFallbackFactory  implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable cause) {
        log.info("fallback reason was: {} ", cause.getMessage());

        return new UserClientFallbackFactory();
        //也可以不写UserClientFallbackFactory类，直接写成以下形式：
//        return new UserFeignClient() {
//            @Override
//            public String getUserName() {
//                return "降级信息";
//            }
//        };

    }

}