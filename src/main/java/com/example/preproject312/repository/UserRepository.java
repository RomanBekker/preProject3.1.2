package com.example.preproject312.repository;

import com.example.preproject312.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
