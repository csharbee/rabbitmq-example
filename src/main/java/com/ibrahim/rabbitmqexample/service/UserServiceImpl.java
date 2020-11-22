package com.ibrahim.rabbitmqexample.service;

import com.ibrahim.rabbitmqexample.dtos.UserDTO;
import com.ibrahim.rabbitmqexample.mapper.UserMapper;
import com.ibrahim.rabbitmqexample.model.User;
import com.ibrahim.rabbitmqexample.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public void saveUser(UserDTO userDTO) {
        User user =  userMapper.userDTOToUser(userDTO);
        userRepository.save(user);

    }
}
