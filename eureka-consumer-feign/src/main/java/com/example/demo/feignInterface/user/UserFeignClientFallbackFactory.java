package com.example.demo.feignInterface.user;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 服务降级，
 */
@Slf4j
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable cause) {
        System.out.println("====================================》fallback reason was:  " + cause.getMessage());

        return new UserFeignClientHystrix();
        //也可以不写UserClientFallbackFactory类，直接用匿名对象写成以下形式：
//        return new UserFeignClient(Integer id) {
//            @Override
//            public JSONObject getUserNameById() {
//                 JSONObject resultJson = new JSONObject();
//                 resultJson.put("id",  "-1" );
//                 resultJson.put("name", "null"   );
//                 return resultJson;
//            }
//        };

    }

}