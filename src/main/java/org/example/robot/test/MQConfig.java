package org.example.robot.test;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 用于监听MQ
 */
@Component
public class MQConfig {


    @JmsListener(destination = "test_queue")
    public  void  onMessage(String message){


        System.out.print(message);
        //获取到消息后可以干一些事情

    }
}