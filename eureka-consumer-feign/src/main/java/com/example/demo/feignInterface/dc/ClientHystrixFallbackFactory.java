package com.example.demo.feignInterface.dc;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ClientHystrixFallbackFactory  implements FallbackFactory<DcClient> {
    @Override
    public DcClient create(Throwable cause) {
        log.error(" fallback reason was: {} " , cause.getMessage());
        return new DcClientFallbackFactory();
    }
}
