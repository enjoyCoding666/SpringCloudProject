package com.example.demo.feignInterface.user;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallbackFactory implements UserFeignClient {

    /**
     * 服务熔断
     * @param id
     * @return
     */
    @Override
    public JSONObject getUserNameById(Integer id) {
        System.out.println("=======================>UserClientFallbackFactoryTest");
        JSONObject resultJson = new JSONObject();
        resultJson.put("errCode",  "0404" );
        String description="查询id为"+id+"的用户，服务异常，暂时熔断";
        resultJson.put("description", description  );
        return resultJson;
    }


    @Override
    public User getUserById(Integer id) {
        System.out.println("=======================>UserClientFallbackFactoryTest");
         //直接返回id为-1的用户
        User user = new User();
        user.setId(-1);
        return user;
     }

}
