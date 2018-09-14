package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on  九月
 */
@RestController
public class ConfigController {

     @Value("${ foo }")
      private  String name;


      @GetMapping(value = "/name")
      public String name(){
          return  "hello"+name ;
      }
}
