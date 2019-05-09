package com.example.demo;

import com.example.demo.pojo.User;

public class UserTest {
    public static void main(String[] args) {
        User user=User.builder().id(2).name("lin").build();
        System.out.println(user.getId());
    }
}
