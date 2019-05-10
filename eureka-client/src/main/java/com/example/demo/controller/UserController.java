package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

        @PostMapping("/user/name/{id}")
        public JSONObject getUserNameById(@PathVariable("id") Integer id ) throws Exception {
            System.out.println("==================================================================>getUserNameById()，id为："+id);
            //直接抛异常，是为了测试服务熔断和降级。
            throw  new Exception("getUserNameByIdException");
        }

       @PostMapping("/user")
       public User getUserById(@RequestParam("id") Integer id  ) throws Exception {
         System.out.println("==================================================================>getUserById(),id为："+id);
         throw  new Exception("getUserByIdException");
      }

}
