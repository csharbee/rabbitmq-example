package com.ibrahim.rabbitmqexample.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfiguration {

    @Value("${sr.rabbit.queue.name}")
    private String queueName;

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @Value("${sr.rabbit.dead.letter.queue}")
    private String deadLetterQueue;

    @Value("${sr.rabbit.dead.letter.exchange}")
    private String deadLetterExchange;

    @Value("${sr.rabbit.dead.letter.routing}")
    private String deadLetterRouting;

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }


    @Bean
    Queue deadLetterQueue() {
        return new Queue(deadLetterQueue);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public DirectExchange deadLetterDirectExchange() {
        return new DirectExchange(deadLetterExchange);
    }

    @Bean
    public Binding binding(final Queue queue, final DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(routingName);
    }

    @Bean
    public Binding deadLetterBinding(final Queue deadLetterQueue, final DirectExchange deadLetterDirectExchange) {
        return BindingBuilder.bind(deadLetterQueue).to(deadLetterDirectExchange).with(deadLetterRouting);
    }



}
