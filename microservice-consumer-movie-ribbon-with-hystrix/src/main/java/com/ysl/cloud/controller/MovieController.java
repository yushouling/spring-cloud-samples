package com.ysl.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ysl.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.Random;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/movie/{id}")
  @HystrixCommand(fallbackMethod = "fallback")
  public User findById(@PathVariable Long id) {
    if(new Random().nextInt(10) <= 5) {
      // System.out.println("发生异常!");
      throw new RuntimeException();
    }
    return restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
  }

  /**
   * 在@HystrixCommand标注的方法发生异常时调用
   * <pre>方法返回值和参数需要与标注的方法保持一致</pre>
   * @param id
   * @return
   */
  public User fallback(Long id) {
    System.out.println("findById()发生异常或失败.");
    // 服务发生异常时的降级解决方案，创建一个空的User对象返回
    return new User();
  }

}
