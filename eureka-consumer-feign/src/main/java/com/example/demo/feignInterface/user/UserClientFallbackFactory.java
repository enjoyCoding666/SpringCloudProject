package com.example.demo.feignInterface.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserClientFallbackFactory implements UserFeignClient {

    @Override
    public String getUserName() {
        log.debug("=======================>UserClientFallbackFactoryTest");
        return "UserClientFallbackFactoryTest";
    }
}
