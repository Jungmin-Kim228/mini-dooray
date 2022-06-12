package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/taskRegister/{projectNo}")
    public String taskRegister(@PathVariable("projectNo") Integer projectNo,
                               Authentication authentication, Model model) {
        String userName = ((User) authentication.getPrincipal()).getUsername();
        model.addAttribute("projectNo", projectNo);
        model.addAttribute("userName", userName);
        return "taskRegisterForm";
    }
}
