package com.ibrahim.rabbitmqexample.producer;

import com.ibrahim.rabbitmqexample.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationProducer {

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;


    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendToQueueNewUserMessage() {
        Notification notification = new Notification();
        notification.setCreatedDate(new Date());
        notification.setMessage("New user saved to database");
        System.out.println("Notification Sent Message : " + notification.getMessage());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
    }


    public void sendToQueueFindAllMessage() {
        Notification notification = new Notification();
        notification.setCreatedDate(new Date());
        notification.setMessage("Gets all users from database");
        System.out.println("Notification Sent Message : " + notification.getMessage());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
    }


    public void sendToQueueDeletedUserById() {
        Notification notification = new Notification();
        notification.setCreatedDate(new Date());
        notification.setMessage("Deleted user by id from database");
        System.out.println("Notification Sent Message : " + notification.getMessage());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
    }
}