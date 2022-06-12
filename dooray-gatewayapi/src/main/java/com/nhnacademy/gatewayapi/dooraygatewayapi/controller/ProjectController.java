package com.nhnacademy.gatewayapi.dooraygatewayapi.controller;

import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.MilestoneDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectRequest;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.ProjectUserDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TagDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.domain.TaskDto;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.MilestoneService;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.ProjectService;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.ProjectUserService;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.TagService;
import com.nhnacademy.gatewayapi.dooraygatewayapi.service.TaskService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final TaskService taskService;
    private final TagService tagService;
    private final MilestoneService milestoneService;
    private final ProjectUserService projectUserService;

    @GetMapping("/projectList")
    public String projectList(Authentication authentication, Model model) {
        Object principal = authentication.getPrincipal();
        String userName = ((User) principal).getUsername();
        List<ProjectDto> projectRequestList = projectService.getOwnProject(userName);
        model.addAttribute("projects", projectRequestList);
        return "project/projectList";
    }

    @GetMapping("/projectRegister")
    public String projectRegisterForm(Authentication authentication, Model model) {
        String userName = ((User) authentication.getPrincipal()).getUsername();
        model.addAttribute("userName", userName);
        return "project/projectRegisterForm";
    }

    @PostMapping("/project/register")
    public String projectRegister(@ModelAttribute ProjectRequest projectRequest) {
        projectService.registerProject(projectRequest);
        return "redirect:/projectList";
    }

    @GetMapping("/project/detail/{projectNo}")
    public String projectDetail(@PathVariable("projectNo") Integer projectNo, Model model) {
        String projectName = projectService.getProjectNameByNo(projectNo);
        List<TaskDto> taskDtoList = taskService.getTaskDtoByProjectNo(projectNo);
        List<MilestoneDto> milestoneDtoList = milestoneService.getMilestoneDtoByProjectNo(projectNo);
        List<TagDto> tagDtoList = tagService.getTagDtoByProjectNo(projectNo);
        List<ProjectUserDto> projectUserDtoList = projectUserService.getProjectUserDtoByProjectNo(projectNo);

        model.addAttribute("projectName", projectName);
        model.addAttribute("tasks", taskDtoList);
        model.addAttribute("milestones", milestoneDtoList);
        model.addAttribute("tags", tagDtoList);
        model.addAttribute("members", projectUserDtoList);
        return "project/projectDetail";
    }
}
