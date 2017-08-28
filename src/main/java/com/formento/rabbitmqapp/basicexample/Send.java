package com.formento.rabbitmqapp.basicexample;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    private final static String QUEUE_NAME = "hello";

    // And after run Recv.java, run this
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //for (int i = 0; i < 200000; i++) {
        int i = 0;
        while (true) {
            i++;
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World! " + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

            if (i % 1000 == 0) {
                System.out.println(" [x] Sent '" + message + "'");
            }
        }

//        channel.close();
//        connection.close();
    }
}
