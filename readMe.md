一、遇到的问题 <br>
0.SpringCloud有多个版本，引入了不合适的版本，就有可能报错。  <br>
1.分布式配置中心。访问的url格式有多样。可以是localhost://application/profile/label，也可以是其他  <br>
访问Config服务端，http://localhost:3001/config-client/dev/master 跟 http://localhost:3001/config-client/lin/master的内容不一样？ <br>
为什么profile只有设定为dev才可以查看config-client-dev.yml的内容。 <br>
解决方案： 在spring.cloud.config.profile 这个配置中， dev表示开发环境配置文件、test表示测试环境、pro表示正式环境  <br>
2.分布式Config中，客户端无法访问服务端配置中心。如何破解？  <br>
3.断路器hystrix不起作用. <br>
解决方案：这是由于版本原因造成的。需要在配置中开启 feign.hystrix.enabled=true   <br>
4.maven打包成jar包后，无法运行？ <br>
解决方法：路径含有中文，无法打包，改成英文就可以了。 <br>
5.配置多个高可用服务注册中心时，<br>
cd G:\JavaWebDemo\SpringCloudProject\eureka-server\target    <br>
java -jar  eureka-server-0.0.1-SNAPSHOT.jar  --spring.profiles.active=peer1  <br>
java -jar  eureka-server-0.0.1-SNAPSHOT.jar  --spring.profiles.active=peer2   <br>
一直报错：
Caused by: org.yaml.snakeyaml.parser.ParserException: while parsing MappingNode  <br>
解决方法： yml配置出错，要正确对齐。 <br>
6.配置高可用eureka服务集群，eureka-client在指定注册中心时，多个注册中心之间不要有空格,否则会出错。。<br>
 defaultZone:  http://peer1:1111/eureka/,http://peer2:1112/eureka/     <br>