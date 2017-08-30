package com.formento.rabbitmqapp.api;

import static org.springframework.util.StringUtils.isEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class SendController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendController.class);

    private final RabbitTemplate rabbitTemplate;

    public SendController(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void send(final String message) {
        final String messageQueue = isEmpty(message) ? "Hello from RabbitMQ!" : message;
        LOGGER.info("Put a message into rabbitmq <" + messageQueue + ">");
        rabbitTemplate.convertAndSend(ApiApplication.queueName, messageQueue);
    }

}
