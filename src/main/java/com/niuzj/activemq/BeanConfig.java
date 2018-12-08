package com.niuzj.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * 参考:https://blog.csdn.net/asdfsadfasdfsa/article/details/53125973
 */
@Configuration
public class BeanConfig {

    @Value("${spring.activemq.broker-url}")
    private String url;

    @Value("${spring.activemq.user}")
    private String user;

    @Value("${spring.activemq.password}")
    private String password;

    @Value("${sys.name}")
    private String name;

    @Bean
    public ActiveMQConnectionFactory getActiveMQConnectionFactory(){
        return new ActiveMQConnectionFactory(user, password, url);
    }

    @Bean
    public JmsTemplate getJmsTemplate(ActiveMQConnectionFactory factory){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(factory);
        //设置手动确认
        jmsTemplate.setSessionAcknowledgeMode(4);
        return jmsTemplate;

    }

    @Bean("jmsListenerContainerFactory")
    public JmsListenerContainerFactory getJmsListenerContainerFactory(ActiveMQConnectionFactory factory){
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(factory);
        //设置手动确认
        jmsListenerContainerFactory.setSessionAcknowledgeMode(4);
        jmsListenerContainerFactory.setPubSubDomain(Boolean.FALSE);
        return jmsListenerContainerFactory;
    }
}
