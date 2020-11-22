package com.ibrahim.rabbitmqexample.mapper;

import com.ibrahim.rabbitmqexample.dtos.UserDTO;
import com.ibrahim.rabbitmqexample.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public User userDTOToUser(UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());

        return user;
    }

    public UserDTO userToUserDTO(User user){

        UserDTO userDTO = new UserDTO();
        userDTO.setAddress(user.getAddress());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}
