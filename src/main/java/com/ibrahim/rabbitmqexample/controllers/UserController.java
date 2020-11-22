package com.ibrahim.rabbitmqexample.controllers;

import com.ibrahim.rabbitmqexample.dtos.UserDTO;
import com.ibrahim.rabbitmqexample.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private UserServiceImpl userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody  UserDTO userDTO){
       userService.saveUser(userDTO);
    }
}
