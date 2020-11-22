package com.ibrahim.rabbitmqexample.repository;

import com.ibrahim.rabbitmqexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
