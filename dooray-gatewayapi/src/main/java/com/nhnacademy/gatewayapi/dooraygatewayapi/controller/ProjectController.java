package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/projectList")
    public String projectList(Authentication authentication, Model model) {
        Object principal = authentication.getPrincipal();
        String userName = ((User) principal).getUsername();
        List<ProjectDto> projectDtoList = projectService.getOwnProject(userName);
        model.addAttribute("projectList", projectDtoList);
        return "projectList";
    }

    @GetMapping("/projectRegister")
    public String projectRegisterForm(Authentication authentication, Model model) {
        String userName = ((User) authentication.getPrincipal()).getUsername();
        model.addAttribute("userName", userName);
        return "projectRegisterForm";
    }

    @PostMapping("/project/register")
    public String projectRegister(@ModelAttribute ProjectDto projectDto) {
        projectService.registerProject(projectDto);
        return "projectList";
    }
}
