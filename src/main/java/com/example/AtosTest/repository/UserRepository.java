package com.example.AtosTest.repository;

import com.example.AtosTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
