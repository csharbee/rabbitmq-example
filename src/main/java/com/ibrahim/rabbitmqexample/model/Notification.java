package com.ibrahim.rabbitmqexample.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Notification implements Serializable {

    private String message;
    private Date createdDate;

}
