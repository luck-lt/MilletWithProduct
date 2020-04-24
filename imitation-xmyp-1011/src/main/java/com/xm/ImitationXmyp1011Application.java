package com.xm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*@MapperScan("com.xm.dao")*/
@ServletComponentScan("com.xm.interceptor")
@SpringBootApplication
public class ImitationXmyp1011Application {

    public static void main(String[] args) {
        SpringApplication.run(ImitationXmyp1011Application.class, args);
    }

}
