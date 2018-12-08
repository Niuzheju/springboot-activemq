package com.niuzj.activemq.controller;

import com.niuzj.activemq.service.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private JmsService jmsService;

    @RequestMapping("/send")
    public String sendMsg(String msg){
        jmsService.sendMessage("default", msg);
        return "success";
    }

}
