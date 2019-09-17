package com.spring.login.guide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.login.guide.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
