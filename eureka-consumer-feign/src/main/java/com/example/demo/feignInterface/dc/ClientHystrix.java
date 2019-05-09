package com.example.demo.feignInterface.dc;

import org.springframework.stereotype.Component;

/**
 * Created by lenovo on  九月
 */

@Component
public class ClientHystrix implements  DcClient {
    @Override
    public String consumer() {
        return "hystrix";
    }
}
