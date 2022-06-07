package com.xiuxian.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    @RequestMapping("/send")
    public String send() {
        return "send msg success!";
    }
}
