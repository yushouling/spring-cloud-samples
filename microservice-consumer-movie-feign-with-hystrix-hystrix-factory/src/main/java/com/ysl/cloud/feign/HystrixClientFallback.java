package com.ysl.cloud.feign;

import org.springframework.stereotype.Component;

import com.ysl.cloud.entity.User;

@Component
public class HystrixClientFallback implements UserFeignClient {
  @Override
  public User findById(Long id) {
    User user = new User();
    user.setId(0L);
    return user;
  }
}