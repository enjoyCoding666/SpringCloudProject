package com.example.demo.feignInterface.dc;

import org.springframework.stereotype.Component;

@Component
public class DcClientFallbackFactory implements DcClient {
    @Override
    public String consumer() {
        String test="DcClientFallbackFactory";
        return test;
    }
}
