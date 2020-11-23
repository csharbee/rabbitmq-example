package com.ibrahim.rabbitmqexample.listener;

import com.ibrahim.rabbitmqexample.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "notification-queue")
    public void handleNotification(Notification notification) {
        System.out.println("Message received..");
        System.out.println(notification.toString());
    }
}
