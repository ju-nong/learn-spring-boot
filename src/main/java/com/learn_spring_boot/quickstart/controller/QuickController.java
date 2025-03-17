package com.learn_spring_boot.quickstart.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class QuickController {
    @GetMapping("/dummy")
    public String dummy() {
        log.info("dummy");
        return "dummy";
    }

    @GetMapping("/dummy2")
    public String dummy2() {
        log.info("dummy2");
        return "dummy2";
    }
}
