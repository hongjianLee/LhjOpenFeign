package com.lhj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LhjOpenfeignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LhjOpenfeignServiceApplication.class, args);
    }

}
