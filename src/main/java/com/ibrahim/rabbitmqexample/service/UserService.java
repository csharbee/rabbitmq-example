package com.ibrahim.rabbitmqexample.service;

import com.ibrahim.rabbitmqexample.dtos.UserDTO;
import com.ibrahim.rabbitmqexample.repository.UserRepository;


public interface UserService {

    public void saveUser(UserDTO userDTO);
}
