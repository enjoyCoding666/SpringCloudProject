一、遇到的问题 <br>
1.eureka-client中的DiscoveryClient一直报错 <br>
"Field discoveryClient in com.controller.DcController required a bean of type 'com.netflix.discovery.DiscoveryClient' that could not be found."
解决方案： Discovery的包有两个，导入org.springframework.cloud.client.discovery.DiscoveryClient才是正确的。 <br>
2.    new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);和默认生成的 main方法 有什么区别 ？ <br>
3.Caused by: org.springframework.context.ApplicationContextException: Unable to start EmbeddedWebApplicationContext due to missing EmbeddedServletContainerFactory bean.
