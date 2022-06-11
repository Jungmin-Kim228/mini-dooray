package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserId;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/register")
    public String userRegister(@ModelAttribute UserRequest userRequest,
                               Model model) {
        String userId = userService.registerUser(userRequest);
        model.addAttribute("userId", userId);
        // here 세션에 userId 저장하기
        return "userRegisterSuccess";
    }
}