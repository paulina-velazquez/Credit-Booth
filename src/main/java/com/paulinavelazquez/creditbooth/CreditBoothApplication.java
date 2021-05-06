package com.paulinavelazquez.creditbooth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // TODO Look into Ribbon
public class CreditBoothApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditBoothApplication.class, args);
    }

}
