package com.niuzj.activemq.service;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import java.util.HashMap;
import java.util.Map;

@Service
public class JmsService {

    @Autowired
    private JmsTemplate jmsTemplate;

    private Map<String, Destination> queueMap = new HashMap<>();


    /**
     * 发送消息
     */
    public void sendMessage(String queueName, String msg){
        Destination destination = queueMap.get(queueName);
        if (destination == null){
            destination = new ActiveMQQueue(queueName);
            queueMap.put(queueName, destination);
        }
        jmsTemplate.convertAndSend(destination, msg);
    }
}
