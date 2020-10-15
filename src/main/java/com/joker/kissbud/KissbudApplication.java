package com.joker.kissbud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.joker.kissbud.mapper")
public class KissbudApplication {
    public static void main(String[] args) {
        SpringApplication.run(KissbudApplication.class, args);
    }
}
