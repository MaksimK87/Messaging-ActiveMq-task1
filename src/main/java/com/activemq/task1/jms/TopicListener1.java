package com.activemq.task1.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TopicListener1 {

    @Value("${activemq.topic}")
    private String topic;

    @JmsListener(destination = "${activemq.topic}", containerFactory = "topicListenerFactory")
    public void recieveMessageFromTopic(Message message) throws JMSException {

        TextMessage textMessage = (TextMessage) message;
        String messageData = textMessage.getText();
        log.info("Received message: \"" + messageData + "\" from topic: " + topic + " by subscriber 1");
    }


}
