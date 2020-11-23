package com.ibrahim.rabbitmqexample.service;

import com.ibrahim.rabbitmqexample.dtos.UserDTO;
import com.ibrahim.rabbitmqexample.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;


public interface UserService {

    void saveUser(UserDTO userDTO);

    Slice<User> findAll(Pageable pageable);
}
