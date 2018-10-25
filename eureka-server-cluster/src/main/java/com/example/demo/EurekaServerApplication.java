package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    /**
     * 高可用注册中心eureka-server集群，需要通过命令行加载properties文件启动。
     * 先用maven进行clean package命令。生成jar包。然后进入路径执行以下命令：
     * java -jar  eureka-server-0.0.1-SNAPSHOT.jar  --spring.profiles.active=peer1
     * java -jar  eureka-server-0.0.1-SNAPSHOT.jar  --spring.profiles.active=peer2
     *
     * 启动方式 ，详情见 http://blog.didispace.com/springcloud6/
     * @param args
     */
    public static void main(String[] args) {
       new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
    }
}
