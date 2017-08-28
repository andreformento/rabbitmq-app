package com.formento.rabbitmqapp.api;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class SendController {

    private final RabbitTemplate rabbitTemplate;

    public SendController(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void send(final String message) {
        rabbitTemplate.convertAndSend(ApiApplication.queueName, message == null ? "Hello from RabbitMQ!" : message);
    }

}