package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/userRegister")
    public String userRegister() {
        return "userRegister";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }
}
