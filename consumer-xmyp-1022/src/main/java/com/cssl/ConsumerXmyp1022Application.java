package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@EnableDiscoveryClient
@ServletComponentScan(basePackages = "com.cssl.file")
@SpringBootApplication
public class ConsumerXmyp1022Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerXmyp1022Application.class, args);
    }

}
