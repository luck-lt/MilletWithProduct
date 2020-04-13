package com.xm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.xm.dao")
@SpringBootApplication
public class ImitationXmyp1011Application {

    public static void main(String[] args) {
        SpringApplication.run(ImitationXmyp1011Application.class, args);
    }

}
