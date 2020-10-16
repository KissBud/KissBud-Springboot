package com.joker.kissbud.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/test")
    public void showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);
    }
}