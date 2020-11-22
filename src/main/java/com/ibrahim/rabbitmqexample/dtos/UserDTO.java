package com.ibrahim.rabbitmqexample.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private String name;
    private String email;
    private String address;
}
