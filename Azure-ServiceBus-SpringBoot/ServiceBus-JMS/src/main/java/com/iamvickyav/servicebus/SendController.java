package com.iamvickyav.servicebus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    private static final String DESTINATION_NAME = "tn50v";

    private static final String DESTINATION_TOPIC_NAME = "springcloudbus";

    private static final Logger logger = LoggerFactory.getLogger(SendController.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/messages")
    public String postMessage(@RequestParam String message) {
        logger.info("Sending message");
        jmsTemplate.convertAndSend(DESTINATION_NAME, new User(message));
        return message;
    }

    @PostMapping("/topic-messages")
    public String postTopicMessage(@RequestParam String message) {
        logger.info("Sending Topic message");
        jmsTemplate.convertAndSend(DESTINATION_TOPIC_NAME, new User(message));
        return message;
    }
}
