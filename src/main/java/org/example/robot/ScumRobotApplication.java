package org.example.robot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(exclude= SolrAutoConfiguration.class)
@MapperScan("org.example.robot.mapper")
public class ScumRobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScumRobotApplication.class, args);
    }

}
