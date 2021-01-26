package ru.pflb.ershov;

import com.ershov.order.MessageToQueue;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;


@SpringBootApplication
public class main{


    @Value("${inbound.endpoint}")
    private static final Logger logger = LoggerFactory.getLogger(main.class);

    public static void main(String[] args) {
        SpringApplication.run(main.class, args);


    }

    @JmsListener(destination = "${inbound.endpoint}")
    public void process(MessageToQueue messageToQueue) {
        logger.info("My message from queue: ", messageToQueue.getBodyMessage(), messageToQueue.getMessage());
        System.out.println(messageToQueue.getBodyMessage());
    }

}