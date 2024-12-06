package org.example.robot.test;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * 专门配置mq通道的配置类
 */
@Configuration
public class QueueConfig {

    @Bean(name = "queueName")
    Queue queueName(){

        return  new ActiveMQQueue("test_queue");
    }


}
