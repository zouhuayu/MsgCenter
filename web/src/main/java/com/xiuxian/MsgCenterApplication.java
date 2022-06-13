package com.xiuxian;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MsgCenterApplication {
    public static void main(String[] args) {
        log.info("============");
        SpringApplication.run(MsgCenterApplication.class, args);
    }
}