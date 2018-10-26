package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hystrix Dashboard进行监控。
 * 启动应用，访问 http://localhost:1301/hystrix  可以看到监控页面。
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboard {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard.class, args);
    }
}
