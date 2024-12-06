package org.example.robot.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;

@SpringBootTest
public class RedisTest {


    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    Queue queueName;

    @Test
    public void test5(){

        String message="我是发送消息的人，听得到吗";
        jmsMessagingTemplate.convertAndSend(queueName, message);

    }

}
