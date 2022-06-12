package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/userRegister")
    public String userRegister() {
        return "user/userRegister";
    }

    @PostMapping("/user/register")
    public String userRegister(@ModelAttribute UserDto userDto,
                               Model model) {
        String userId = userService.registerUser(userDto);
        model.addAttribute("userId", userId);
        return "user/userRegisterSuccess";
    }
}