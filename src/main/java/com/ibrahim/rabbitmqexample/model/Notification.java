package com.ibrahim.rabbitmqexample.model;

import lombok.Data;

import java.util.Date;

@Data
public class Notification {

    private Long id;
    private String message;
    private Date createdDate;

}
