package com.ibrahim.rabbitmqexample.controllers;

import com.ibrahim.rabbitmqexample.dtos.UserDTO;
import com.ibrahim.rabbitmqexample.model.User;
import com.ibrahim.rabbitmqexample.service.UserServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    private UserServiceImpl userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public Slice<User> getUsers(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

}
