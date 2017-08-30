package com.formento.rabbitmqapp.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receive {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receive.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
