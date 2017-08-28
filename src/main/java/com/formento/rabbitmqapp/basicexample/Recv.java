package com.formento.rabbitmqapp.basicexample;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.time.LocalDateTime;

public class Recv {

    private final static String QUEUE_NAME = "hello";

    // Run this first
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            int i = 0;

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                throws IOException {
                i++;
                if (i % 1000 == 0) {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "' " + LocalDateTime.now());
                }
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
