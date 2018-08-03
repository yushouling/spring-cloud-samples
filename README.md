# spring-cloud-samples
Spring cloud samples with Eureka, Hystrix, Ribbon and so on.


启动顺序，如

1.启动microservice-discovery-eureka

2.启动microservice-provider-user

3.启动microservice-consumer-movie-ribbon-with-hystrix

4.启动microservice-hystrix-dashboard


eureka注册中心：

http://localhost:8761/

发起请求：

http://localhost:8010/movie/1

hystrix实时流量数据：

http://localhost:8010/hystrix.stream

hystrix仪表盘控制台：

http://localhost:8030/hystrix  输入需要监控的hystrix.stream地址
