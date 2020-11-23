package com.ibrahim.rabbitmqexample.model;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.annotation.Documented;
import java.util.Date;

@Data
public class Notification implements Serializable {

    private String message;
    private Date createdDate;

}
