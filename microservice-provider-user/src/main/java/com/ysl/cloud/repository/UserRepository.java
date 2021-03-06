package com.ysl.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ysl.cloud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
