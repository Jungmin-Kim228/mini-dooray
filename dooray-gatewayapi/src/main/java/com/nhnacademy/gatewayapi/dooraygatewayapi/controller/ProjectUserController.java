package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.UserIdOnlyDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.ProjectUserService;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProjectUserController {

    private final ProjectUserService projectUserService;
    private final UserService userService;

    @GetMapping("/projectUser/add/{projectNo}")
    public String projectUserAddForm(@PathVariable("projectNo") Integer projectNo, Model model) {
        List<UserIdOnlyDto> userIds = userService.getAllUserId();
        model.addAttribute("projectNo", projectNo);
        model.addAttribute("userIds", userIds);
        return "projectUser/projectUserAddForm";
    }

//    @PostMapping("")
}
