一、遇到的问题 <br>
0.SpringCloud有多个版本，引入了不合适的版本，就有可能报错。  <br>
1.eureka-client中的DiscoveryClient一直报错 <br>
"Field discoveryClient in com.controller.DcController required a bean of type 'com.netflix.discovery.DiscoveryClient' that could not be found." <br>
解决方案： Discovery的包有两个，导入org.springframework.cloud.client.discovery.DiscoveryClient才是正确的。 <br>
2. new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);和默认生成的 main方法 有什么区别 ？ <br>
3.启动eureka-consumer报错如下： <br>
Caused by: org.springframework.context.ApplicationContextException: Unable to start EmbeddedWebApplicationContext due to missing EmbeddedServletContainerFactory bean.<br>
解决方案： 启动类上方添加@SpringBootApplication。另外，还要注意启动类中的 .class文件名称是否与类名一致。<br>       
new SpringApplicationBuilder(EurekaConsumerApplication.class).web(true).run(args); <br>
4.启动Ribbon进行服务消费，报错：  <br>
com.netflix.discovery.shared.transport.TransportException: Cannot execute request on any known server  <br>
解决方案; 修正 eureka.client.service-url.defaultZone . <br>
5.分布式配置中心。访问的url格式有多样。可以是localhost://application/profile/label，也可以是其他  <br>
访问Config服务端，http://localhost:3001/config-client/dev/master 跟 http://localhost:3001/config-client/lin/master的内容不一样？ <br>
为什么profile只有设定为dev才可以查看config-client-dev.yml的内容。 <br>
解决方案： 在spring.cloud.config.profile 这个配置中， dev表示开发环境配置文件、test表示测试环境、pro表示正式环境  <br>
6.分布式Config中，客户端无法访问服务端配置中心。如何破解？  <br>
7.断路器hystrix不起作用. <br>
解决方案：这是由于版本原因造成的。需要在配置中开启 feign.hystrix.enabled=true   <br>
8.maven打包成jar包后，无法运行？ <br>
路径含有中文，无法打包。 <br>
9.配置多个高可用服务注册中心时，一直报错：
Caused by: org.yaml.snakeyaml.parser.ParserException: while parsing MappingNode  <br>
