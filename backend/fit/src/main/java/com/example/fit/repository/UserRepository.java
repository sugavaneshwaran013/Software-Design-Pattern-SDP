package com.example.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fit.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUserName(String userName);
}
