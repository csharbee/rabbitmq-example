package com.ibrahim.rabbitmqexample.service;

import com.ibrahim.rabbitmqexample.dtos.UserDTO;
import com.ibrahim.rabbitmqexample.mapper.UserMapper;
import com.ibrahim.rabbitmqexample.model.User;
import com.ibrahim.rabbitmqexample.producer.NotificationProducer;
import com.ibrahim.rabbitmqexample.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final NotificationProducer notificationProducer;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, NotificationProducer notificationProducer) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.notificationProducer = notificationProducer;
    }


    @Override
    public void saveUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        userRepository.save(user);
        notificationProducer.sendToQueueNewUserMessage();

    }

    @Override
    public Slice<User> findAll(Pageable pageable) {
        Slice<User> users = userRepository.findAll(pageable);
        notificationProducer.sendToQueueFindAllMessage();
        return users;

    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
        notificationProducer.sendToQueueDeletedUserById();
    }

}
