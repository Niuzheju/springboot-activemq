package com.niuzj.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 消息监听
 */
@Component
public class JmsListenerService {

    @JmsListener(destination = "attest", containerFactory = "jmsListenerContainerFactory")
    public void testMessage(TextMessage message, Session session) {
        try {
            String text = message.getText();
            System.out.println(text);
            int i = Integer.parseInt(text.charAt(text.length() - 1) + "");
            if (i == 20) {
                System.out.println("确认消息");
                message.acknowledge();
            } else {
                session.recover();
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
