package com.learn_spring_boot.quickstart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickController {
    @GetMapping("/dummy")
    public String dummy() {
        return "dummy";
    }

    @GetMapping("/dummy2")
    public String dummy2() {
        return "dummy2";
    }
}
