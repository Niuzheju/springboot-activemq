package com.niuzj.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * 消息监听
 */
@Component
public class JmsListenerService {

    @JmsListener(destination = "default", containerFactory = "jmsListenerContainerFactory")
    public void testMessage(TextMessage message){
        try {
            System.out.println(message.getText());
            message.acknowledge();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
